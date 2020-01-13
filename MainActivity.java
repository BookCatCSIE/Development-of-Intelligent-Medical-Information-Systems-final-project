package com.joejoe2.test_tstts;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;

import android.speech.tts.TextToSpeech;
import android.widget.EditText;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech tts;
    EditText editText;
    TextView textView;
    Button confirmButton,confirmButton2,confirmButton3,confirmButton4,confirmButton5,
            confirmButton6,confirmButton7,confirmButton8,confirmButton9,confirmButton10;

    ArrayList<Crawler3> ccs = new ArrayList<Crawler3>() {{
        add(new Crawler3("https://www.upmedia.mg/news_list.php?Type=24"));
        add(new Crawler3("https://www.upmedia.mg/news_list.php?Type=3"));
        add(new Crawler3("https://www.upmedia.mg/news_list.php?Type=2"));
        add(new Crawler3("https://www.upmedia.mg/news_list.php?Type=5"));
        add(new Crawler3("https://www.upmedia.mg/news_list.php?Type=12"));
        add(new Crawler3("https://www.upmedia.mg/news_list.php?Type=71"));
        add(new Crawler3("https://www.upmedia.mg/news_list.php?Type=82"));
        add(new Crawler3("https://www.upmedia.mg/news_list.php?Type=1"));
        add(new Crawler3("https://www.upmedia.mg/news_list.php?Type=130"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.inputText);
        textView=findViewById(R.id.textView);
        confirmButton=findViewById(R.id.confirmButton);
        confirmButton2=findViewById(R.id.confirmButton2);
        confirmButton3=findViewById(R.id.confirmButton3);
        confirmButton4=findViewById(R.id.confirmButton4);
        confirmButton5=findViewById(R.id.confirmButton5);
        confirmButton6=findViewById(R.id.confirmButton6);
        confirmButton7=findViewById(R.id.confirmButton7);
        confirmButton8=findViewById(R.id.confirmButton8);
        confirmButton9=findViewById(R.id.confirmButton9);
        confirmButton10=findViewById(R.id.confirmButton10);


        confirmButton.setOnClickListener((v)->{
            confirmButton.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFFFFBB33);
            confirmButton3.setBackgroundColor(0xFFFFBB33);
            confirmButton4.setBackgroundColor(0xFFFFBB33);
            confirmButton5.setBackgroundColor(0xFFFFBB33);
            confirmButton6.setBackgroundColor(0xFFFFBB33);
            confirmButton7.setBackgroundColor(0xFFFFBB33);
            confirmButton8.setBackgroundColor(0xFFFFBB33);

            String textt = crawlnews(0);
            editText.setText(textt);
            textView.setText(currentNewsTitle(0));
            speakout();

        });

        confirmButton2.setOnClickListener((v)->{
            confirmButton2.setBackgroundColor(0xFF00DDFF);
            confirmButton.setBackgroundColor(0xFFFFBB33);
            confirmButton3.setBackgroundColor(0xFFFFBB33);
            confirmButton4.setBackgroundColor(0xFFFFBB33);
            confirmButton5.setBackgroundColor(0xFFFFBB33);
            confirmButton6.setBackgroundColor(0xFFFFBB33);
            confirmButton7.setBackgroundColor(0xFFFFBB33);
            confirmButton8.setBackgroundColor(0xFFFFBB33);

            String textt = crawlnews(1);
            editText.setText(textt);
            textView.setText(currentNewsTitle(1));
            speakout();
        });

        confirmButton3.setOnClickListener((v)->{
            confirmButton3.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFFFFBB33);
            confirmButton.setBackgroundColor(0xFFFFBB33);
            confirmButton4.setBackgroundColor(0xFFFFBB33);
            confirmButton5.setBackgroundColor(0xFFFFBB33);
            confirmButton6.setBackgroundColor(0xFFFFBB33);
            confirmButton7.setBackgroundColor(0xFFFFBB33);
            confirmButton8.setBackgroundColor(0xFFFFBB33);

            String textt = crawlnews(2);
            editText.setText(textt);
            textView.setText(currentNewsTitle(2));
            speakout();
        });

        confirmButton4.setOnClickListener((v)->{
            confirmButton4.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFFFFBB33);
            confirmButton3.setBackgroundColor(0xFFFFBB33);
            confirmButton.setBackgroundColor(0xFFFFBB33);
            confirmButton5.setBackgroundColor(0xFFFFBB33);
            confirmButton6.setBackgroundColor(0xFFFFBB33);
            confirmButton7.setBackgroundColor(0xFFFFBB33);
            confirmButton8.setBackgroundColor(0xFFFFBB33);

            String textt = crawlnews(3);
            editText.setText(textt);
            textView.setText(currentNewsTitle(3));
            speakout();
        });

        confirmButton5.setOnClickListener((v)->{
            confirmButton5.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFFFFBB33);
            confirmButton3.setBackgroundColor(0xFFFFBB33);
            confirmButton4.setBackgroundColor(0xFFFFBB33);
            confirmButton.setBackgroundColor(0xFFFFBB33);
            confirmButton6.setBackgroundColor(0xFFFFBB33);
            confirmButton7.setBackgroundColor(0xFFFFBB33);
            confirmButton8.setBackgroundColor(0xFFFFBB33);

            String textt = crawlnews(4);
            editText.setText(textt);
            textView.setText(currentNewsTitle(4));
            speakout();
        });

        confirmButton6.setOnClickListener((v)->{
            confirmButton6.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFFFFBB33);
            confirmButton3.setBackgroundColor(0xFFFFBB33);
            confirmButton4.setBackgroundColor(0xFFFFBB33);
            confirmButton5.setBackgroundColor(0xFFFFBB33);
            confirmButton.setBackgroundColor(0xFFFFBB33);
            confirmButton7.setBackgroundColor(0xFFFFBB33);
            confirmButton8.setBackgroundColor(0xFFFFBB33);

            String textt = crawlnews(5);
            editText.setText(textt);
            textView.setText(currentNewsTitle(5));
            speakout();
        });

        confirmButton7.setOnClickListener((v)->{
            confirmButton7.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFFFFBB33);
            confirmButton3.setBackgroundColor(0xFFFFBB33);
            confirmButton4.setBackgroundColor(0xFFFFBB33);
            confirmButton5.setBackgroundColor(0xFFFFBB33);
            confirmButton6.setBackgroundColor(0xFFFFBB33);
            confirmButton.setBackgroundColor(0xFFFFBB33);
            confirmButton8.setBackgroundColor(0xFFFFBB33);

            String textt = crawlnews(6);
            editText.setText(textt);
            textView.setText(currentNewsTitle(6));
            speakout();
        });

        confirmButton8.setOnClickListener((v)->{
            confirmButton8.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFFFFBB33);
            confirmButton3.setBackgroundColor(0xFFFFBB33);
            confirmButton4.setBackgroundColor(0xFFFFBB33);
            confirmButton5.setBackgroundColor(0xFFFFBB33);
            confirmButton6.setBackgroundColor(0xFFFFBB33);
            confirmButton7.setBackgroundColor(0xFFFFBB33);
            confirmButton.setBackgroundColor(0xFFFFBB33);

            String textt = crawlnews(7);
            editText.setText(textt);
            textView.setText(currentNewsTitle(7));
            speakout();
        });


        confirmButton9.setOnClickListener((v)->{
            editText.setText("");
            textView.setText("");
            speakout();
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);

        });

        confirmButton10.setOnClickListener((v)->{
            editText.setText("");
            textView.setText("");
            speakout();

            confirmButton.setBackgroundColor(0xFFFFBB33);
            confirmButton2.setBackgroundColor(0xFFFFBB33);
            confirmButton3.setBackgroundColor(0xFFFFBB33);
            confirmButton4.setBackgroundColor(0xFFFFBB33);
            confirmButton5.setBackgroundColor(0xFFFFBB33);
            confirmButton6.setBackgroundColor(0xFFFFBB33);
            confirmButton7.setBackgroundColor(0xFFFFBB33);
            confirmButton8.setBackgroundColor(0xFFFFBB33);

        });

        tts=new TextToSpeech(this,this);
    }

    @Override
    public void onInit(int status) {
        if(status==TextToSpeech.SUCCESS){
            tts.setPitch(0.2f);
            tts.setSpeechRate(1.5f);
            int result=tts.setLanguage(Locale.CHINESE);
            if(result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("tts","lang not supported");
            }else {
                confirmButton.setEnabled(true);
            }
        }else{
            Log.e("tts","tts init fail");
        }

    }

    @Override
    public void onDestroy() {
        if(tts!=null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    void speakout(){
        tts.speak(editText.getText().toString().trim(),TextToSpeech.QUEUE_FLUSH,null);

    }

    String currentNewsTitle(int i) {
        return ccs.get(i).getTitle();
    }

    String crawlnews(int i){
        Crawler3 cc = ccs.get(i);
        do {
            if (cc.isNeverUsed()) {
                cc.start_getting_links();
                cc.wait_for_links();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            cc.start_getting_content();
            cc.wait_for_content();
        } while (cc.getContent().equals(""));
        return cc.getContent();
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------------
    class Chi2Tai extends AsyncTask<String , Void, String>
    {
        private static final String TAG = "Chinese2Taiwanese";
        private static final String token = "eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJ3bW1rcy5jc2llLmVkdS50dyIsInNlcnZpY2VfaWQiOiI5IiwibmJmIjoxNTc3NDI2OTU2LCJzY29wZXMiOiIwIiwidXNlcl9pZCI6IjEwOCIsImlzcyI6IkpXVCIsInZlciI6MC4xLCJpYXQiOjE1Nzc0MjY5NTYsInN1YiI6IiIsImlkIjoyNTAsImV4cCI6MTY0MDQ5ODk1Nn0.F9iNkA_pgCCDq_0W_B5JFEhWlLfIiYCBjog3Bg-wmWXnYvf5LxzV131-TQSod4h6Nw8yjbdGMtVEdfp0fHKdyZdnvR8ejbU9yK3qfrTgyrFH9y0ft6ueLncoXogMlSlX_v9UPxu2ORD9Ccmdp1wQRTdJzkZqVozaM3N6wnbqMO4";
        private String result=null;

        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG,strings[0]);

            String outmsg = token + "@@@" + strings[0];

            Socket socket = new Socket();
            InetSocketAddress isa = new InetSocketAddress("140.116.245.149", 27001);

            try {
                //將outmsg轉成byte[]
                byte[] token_et_s = outmsg.getBytes();
                //用於計算outmsg的byte數
                byte[] g = new byte[4];

                g[0] = (byte) ((token_et_s.length & 0xff000000) >>> 24);
                g[1] = (byte) ((token_et_s.length & 0x00ff0000) >>> 16);
                g[2] = (byte) ((token_et_s.length & 0x0000ff00) >>> 8);
                g[3] = (byte) ((token_et_s.length & 0x000000ff));

                socket.connect(isa, 10000);

                BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                // 送出字串
                out.write(byteconcate(g, token_et_s));
                out.flush();

                // 接收字串
                BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
                byte[] b = new byte[1024];
                while (in.read(b) > 0)// <=0的話就是結束了
                    result = new String(b, Charset.forName("UTF-8"));
                out.close();
                in.close();
                socket.close();
                return result;

            } catch (IOException ex) {
                Log.e(TAG, "doInBackground: request failed", ex);
                return ex.getMessage();
            } catch (NullPointerException ex) {
                Log.e(TAG, "doInBackground: received empty response", ex);
                return ex.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if(s!=null)
            {
                Log.d(TAG,Integer.toString(s.length()));
                Log.d(TAG,s);
                String[] convert = s.split("\u0000");   //切除亂碼
                Log.d(TAG,convert[0]);
                editText.setText(convert[0]);/////////////////////////////////////////////////////////////////////////////////////////////////
                return;
            }
        }

        private byte[] byteconcate(byte[] a, byte[] b)
        {
            byte[] result = new byte[a.length + b.length];
            System.arraycopy(a, 0, result, 0, a.length);
            System.arraycopy(b, 0, result, a.length, b.length);
            return result;
        }
    }







}
