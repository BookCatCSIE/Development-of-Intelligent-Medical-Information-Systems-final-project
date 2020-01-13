package com.joejoe2.test_tstts;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;

class Crawler3 {
    Crawler3(String url) {
        this.size = this.index = this.last_index = 0;
        this.links = null;
        this.titles = null;
        this.worker1 = null;
        this.worker2 = null;
        this.content = "";
        this.urltarget = url;//////
        this.neverUsed = true;
    }
    void start_getting_content() {
        Crawler3 self = this;
        this.worker2 = new Thread() {
            @Override
            public void run() {
                //find content of chosen news
                try {
                    String link;
                    synchronized (self) {
                        link = self.links.get(self.index);
                        self.last_index = self.index;
                        if(++self.index >= self.size) self.index = 0;
                        //System.out.println(String.format("%d %d %s", self.index, self.size, link));
                    }
                    Document doc = Jsoup.connect(link).execute().bufferUp().parse();
                    Elements contents = doc.select(".editor p");
                    synchronized (self) {
                        self.content = "";
                        for (Element content : contents) {
                            if (content.html().contains("&nbsp;")) { // ignore blanks
                                continue;
                            }
                            String text = content.html();
                            String parsedText = text.replaceAll("<.*?>", "");
                            parsedText = parsedText.replaceAll("（.*?）", "");
                            if (parsedText.startsWith("【上報徵稿】") || parsedText.startsWith("【延伸閱讀】")) { // ignore ads
                                break;
                            }
                            self.content = self.content.concat(parsedText);
                        }
                        self.notify();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        worker2.start();
    }
    void start_getting_links() {
        Crawler3 self = this;
        this.worker1 = new Thread() {
            @Override
            public void run() {
                try {
                    //find news and choose random one
                    Document doc = Jsoup.connect(urltarget).get();//////
                    Elements newsHeadlines = doc.select("#news-list .wrap .top-dl dl dd a");
                    int size = 0;
                    for (Element headline : new Elements(newsHeadlines)) {
                        if(headline.parent().is(".tag, .author")) { // ignore other links
                            newsHeadlines.remove(headline);
                        } else {
                            ++size;
                        }
                    }
                    synchronized(self) {
                        self.index = 0;
                        self.neverUsed = false;
                        self.size = size;
                        self.links = new ArrayList<String>();
                        self.titles = new ArrayList<String>();
                        for (Element headline : new Elements(newsHeadlines)) {
                            self.links.add(headline.absUrl("href"));
                            self.titles.add(headline.html());
                        }
                        self.notify();
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        };
        worker1.start();
    }
    String getContent() {
        return content;
    }
    boolean isNeverUsed() {
        return this.neverUsed;
    }
    void wait_for_links() {
        synchronized(this) {
            if(worker1 == null) return;
            try {
                this.wait();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    void wait_for_content() {
        synchronized(this) {
            if(worker2 == null) return;
            try {
                this.wait();
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    String getTitle() {
        return titles.get(last_index);
    }
    private ArrayList<String> links;
    private ArrayList<String> titles;
    private String content;
    private Thread worker1;
    private Thread worker2;
    private String urltarget;//////
    private boolean neverUsed;
    private int index, last_index, size;
}
