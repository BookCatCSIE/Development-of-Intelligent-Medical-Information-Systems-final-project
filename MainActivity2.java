package com.joejoe2.test_tstts;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;

//import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.net.rtp.AudioStream;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import android.media.MediaPlayer;
import android.net.Uri;
import android.net.rtp.AudioStream;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.Charset;



public class MainActivity2 extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextToSpeech tts;
    EditText editText;
    TextView textView;
    Button confirmButton,confirmButton2,confirmButton3,confirmButton4,confirmButton5,
            confirmButton6,confirmButton7,confirmButton8,confirmButton9,confirmButton10;
    private File recordFile;
    String inputEx = "";


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
        setContentView(R.layout.activity_main2);

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
        confirmButton10=findViewById(R.id.confirmButton11);


        confirmButton.setOnClickListener((v)->{
            confirmButton.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFF99CC00);
            confirmButton3.setBackgroundColor(0xFF99CC00);
            confirmButton4.setBackgroundColor(0xFF99CC00);
            confirmButton5.setBackgroundColor(0xFF99CC00);
            confirmButton6.setBackgroundColor(0xFF99CC00);
            confirmButton7.setBackgroundColor(0xFF99CC00);
            confirmButton8.setBackgroundColor(0xFF99CC00);

            String textt = crawlnews(0);
            new MainActivity2.C2TL().execute(textt);
            textView.setText(currentNewsTitle(0));
            new MainActivity2.TVL().execute(editText.getText().toString());

        });

        confirmButton2.setOnClickListener((v)->{
            confirmButton2.setBackgroundColor(0xFF00DDFF);
            confirmButton.setBackgroundColor(0xFF99CC00);
            confirmButton3.setBackgroundColor(0xFF99CC00);
            confirmButton4.setBackgroundColor(0xFF99CC00);
            confirmButton5.setBackgroundColor(0xFF99CC00);
            confirmButton6.setBackgroundColor(0xFF99CC00);
            confirmButton7.setBackgroundColor(0xFF99CC00);
            confirmButton8.setBackgroundColor(0xFF99CC00);

            String textt = crawlnews(1);
            new MainActivity2.C2TL().execute(textt);
            textView.setText(currentNewsTitle(1));
            new MainActivity2.TVL().execute(editText.getText().toString());
        });

        confirmButton3.setOnClickListener((v)->{
            confirmButton3.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFF99CC00);
            confirmButton.setBackgroundColor(0xFF99CC00);
            confirmButton4.setBackgroundColor(0xFF99CC00);
            confirmButton5.setBackgroundColor(0xFF99CC00);
            confirmButton6.setBackgroundColor(0xFF99CC00);
            confirmButton7.setBackgroundColor(0xFF99CC00);
            confirmButton8.setBackgroundColor(0xFF99CC00);

            String textt = crawlnews(2);
            new MainActivity2.C2TL().execute(textt);
            textView.setText(currentNewsTitle(2));
            new MainActivity2.TVL().execute(editText.getText().toString());
        });

        confirmButton4.setOnClickListener((v)->{
            confirmButton4.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFF99CC00);
            confirmButton3.setBackgroundColor(0xFF99CC00);
            confirmButton.setBackgroundColor(0xFF99CC00);
            confirmButton5.setBackgroundColor(0xFF99CC00);
            confirmButton6.setBackgroundColor(0xFF99CC00);
            confirmButton7.setBackgroundColor(0xFF99CC00);
            confirmButton8.setBackgroundColor(0xFF99CC00);

            String textt = crawlnews(3);
            new MainActivity2.C2TL().execute(textt);
            textView.setText(currentNewsTitle(3));
            new MainActivity2.TVL().execute(editText.getText().toString());
        });

        confirmButton5.setOnClickListener((v)->{
            confirmButton5.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFF99CC00);
            confirmButton3.setBackgroundColor(0xFF99CC00);
            confirmButton4.setBackgroundColor(0xFF99CC00);
            confirmButton.setBackgroundColor(0xFF99CC00);
            confirmButton6.setBackgroundColor(0xFF99CC00);
            confirmButton7.setBackgroundColor(0xFF99CC00);
            confirmButton8.setBackgroundColor(0xFF99CC00);

            String textt = crawlnews(4);
            new MainActivity2.C2TL().execute(textt);
            textView.setText(currentNewsTitle(4));
            new MainActivity2.TVL().execute(editText.getText().toString());
        });

        confirmButton6.setOnClickListener((v)->{
            confirmButton6.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFF99CC00);
            confirmButton3.setBackgroundColor(0xFF99CC00);
            confirmButton4.setBackgroundColor(0xFF99CC00);
            confirmButton5.setBackgroundColor(0xFF99CC00);
            confirmButton.setBackgroundColor(0xFF99CC00);
            confirmButton7.setBackgroundColor(0xFF99CC00);
            confirmButton8.setBackgroundColor(0xFF99CC00);

            String textt = crawlnews(5);
            new MainActivity2.C2TL().execute(textt);
            textView.setText(currentNewsTitle(5));
            new MainActivity2.TVL().execute(editText.getText().toString());
        });

        confirmButton7.setOnClickListener((v)->{
            confirmButton7.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFF99CC00);
            confirmButton3.setBackgroundColor(0xFF99CC00);
            confirmButton4.setBackgroundColor(0xFF99CC00);
            confirmButton5.setBackgroundColor(0xFF99CC00);
            confirmButton6.setBackgroundColor(0xFF99CC00);
            confirmButton.setBackgroundColor(0xFF99CC00);
            confirmButton8.setBackgroundColor(0xFF99CC00);

            String textt = crawlnews(6);
            new MainActivity2.C2TL().execute(textt);
            textView.setText(currentNewsTitle(6));
            new MainActivity2.TVL().execute(editText.getText().toString());
        });

        confirmButton8.setOnClickListener((v)->{
            confirmButton8.setBackgroundColor(0xFF00DDFF);
            confirmButton2.setBackgroundColor(0xFF99CC00);
            confirmButton3.setBackgroundColor(0xFF99CC00);
            confirmButton4.setBackgroundColor(0xFF99CC00);
            confirmButton5.setBackgroundColor(0xFF99CC00);
            confirmButton6.setBackgroundColor(0xFF99CC00);
            confirmButton7.setBackgroundColor(0xFF99CC00);
            confirmButton.setBackgroundColor(0xFF99CC00);

            String textt = crawlnews(7);
            new MainActivity2.C2TL().execute(textt);
            textView.setText(currentNewsTitle(7));
            new MainActivity2.TVL().execute(editText.getText().toString());
        });


        confirmButton9.setOnClickListener((v)->{
            editText.setText("");
            textView.setText("");
            speakout();
            Intent intent=new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
        });

        confirmButton10.setOnClickListener((v)->{
            editText.setText("");
            textView.setText("");
            speakout();

            confirmButton.setBackgroundColor(0xFF99CC00);
            confirmButton2.setBackgroundColor(0xFF99CC00);
            confirmButton3.setBackgroundColor(0xFF99CC00);
            confirmButton4.setBackgroundColor(0xFF99CC00);
            confirmButton5.setBackgroundColor(0xFF99CC00);
            confirmButton6.setBackgroundColor(0xFF99CC00);
            confirmButton7.setBackgroundColor(0xFF99CC00);
            confirmButton8.setBackgroundColor(0xFF99CC00);

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

    class C2TL extends AsyncTask<String , Void, String>
    {
        private static final String TAG = "Chinese2TaiL";
        private static final String token = "eyJhbGciOiJSUzUxMiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJ3bW1rcy5jc2llLmVkdS50dyIsInNlcnZpY2VfaWQiOiIxNyIsIm5iZiI6MTU3ODE5MzUwNSwic2NvcGVzIjoiMCIsInVzZXJfaWQiOiI4OCIsImlzcyI6IkpXVCIsInZlciI6MC4xLCJpYXQiOjE1NzgxOTM1MDUsInN1YiI6IiIsImlkIjoyNTUsImV4cCI6MTczNTg3MzUwNX0.r2bOx3KpZ2JhFq-QAMnKncMSIjOVRjF4vHF8VlIVx6S4jGgHqnW9075xBFNC-Cl6P7xhnVxdzgME9mSB6G3iUy_DfsdjUXUTUpxaNfgWmVIEpBz3r0_glUGccxEd154-zuFNffqs8oSEMCdoivYMzYG2v_lNjMjXwryHU3JrV5g";
        private String result=null;

        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG,strings[0]);

            String outmsg = token + "@@@" + strings[0];

            Socket socket = new Socket();
            InetSocketAddress isa = new InetSocketAddress("140.116.245.149", 27005);

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
                editText.setText(convert[0]);
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

    //--------------------------------------------------------------------------------------------------------------------------------------------------------------------

    class TVL extends AsyncTask<String , Void, String>
    {
        private static final String TAG = "TaiwaneseVoice";
        private String result=null;

        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG,strings[0]);


            String outmsg = strings[0];

            Socket socket = new Socket();
            InetSocketAddress isa = new InetSocketAddress("140.116.245.147", 50006);

            try {
                //將outmsg轉成byte[]
                byte[] token_et_s = outmsg.getBytes(StandardCharsets.UTF_8);
                //用於計算outmsg的byte數

                socket.connect(isa, 10000);

                BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                // 送出字串
                out.write(token_et_s);
                out.flush();

                // 接收
                BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
                String path = getCacheDir() + "/output.wav";//"/storage/emulated/0/DCIM/output.wav";
                FileOutputStream fos = new FileOutputStream(path);
                byte[] b = new byte[1024];
                int count = 0 ;
                while ((count = in.read(b)) > 0)// <=0的話就是結束了
                {
                    Log.d("byte length : ", Integer.toString(b.length));
                    fos.write(b, 0, count);

                }

                out.close();
                in.close();
                socket.close();
                result = path;
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
                //resultText.setText(s);

                final MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(MainActivity2.this, Uri.parse(s));
                Log.d(TAG,s);
                mediaPlayer.start();
                Log.d(TAG,s);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer MP) {
                        mediaPlayer.release();
                    }
                });

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
