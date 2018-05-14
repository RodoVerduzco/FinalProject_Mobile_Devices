package mx.itesm.csf.proyectofinal;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import java.util.Random;

public class VideoSplash extends AppCompatActivity {

    VideoView video_splash;

    final String baseURL= "http://ubiquitous.csf.itesm.mx/~pddm-1366134/ExamenFinal/splash/Video/";
    String video_url;
    final int VIDEO_NUM = 2;

    final Random rnd = new Random();
    String vidName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_splash);

        video_splash = (VideoView) findViewById(R.id.video_splash);

        /*RANDOM IMAGE NAME*/
        vidName = "splash" + rnd.nextInt(500)%VIDEO_NUM; // 3 vid
        video_url = baseURL + vidName;

        try
        {
            Uri uri = Uri.parse(video_url);
            video_splash.setVideoURI(uri);
            video_splash.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });

        }
        catch(Exception ex)
        {
            Log.e("ERROR", "There was a mistake: "+ ex);
        }
        video_splash.requestFocus();
        video_splash.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video_splash.start();
            }
        });

    }
}
