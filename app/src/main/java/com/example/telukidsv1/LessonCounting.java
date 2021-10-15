package com.example.telukidsv1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

public class LessonCounting extends AppCompatActivity {

    VideoView videoViewCN;
    String videoPathCN;
    Uri uriCN;
    ImageButton backbtnCN, nextbtnCN;
    MediaController mediaController;
    MediaPlayer sfx;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        videoViewCN = findViewById(R.id.video);
        backbtnCN = findViewById(R.id.btnback);
        nextbtnCN = findViewById(R.id.nextbtn);

        mediaController = new MediaController(this);
        videoViewCN.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCN);

        BackgroundSoundService.onPause();

        countx();
    }

    public void countx() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.countx;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                
                videoViewCN.start();

            }
        });

        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count1();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                startActivity(new Intent(LessonCounting.this, ChooseModeCounting.class));

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count1();

            }
        });

    }

    public void count1() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count1;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count2();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                countx();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count2();

            }
        });

    }

    public void count2() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count2;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count3();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count1();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count3();

            }
        });

    }

    public void count3() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count3;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count4();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count2();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count4();

            }
        });

    }

    public void count4() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count4;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count5();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count3();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count5();

            }
        });

    }

    public void count5() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count5;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count6();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count4();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count6();

            }
        });

    }

    public void count6() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count6;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count7();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count5();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count7();

            }
        });

    }

    public void count7() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count7;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count8();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count6();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count8();

            }
        });

    }

    public void count8() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count8;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count9();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count7();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count9();

            }
        });

    }

    public void count9() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count9;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count10();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count8();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count10();

            }
        });

    }

    public void count10() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count10;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count11();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count9();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count11();

            }
        });

    }

    public void count11() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count11;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count12();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count10();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count12();

            }
        });

    }

    public void count12() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count12;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count13();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count11();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count13();

            }
        });

    }

    public void count13() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count13;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count14();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count12();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count14();

            }
        });

    }

    public void count14() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count14;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count15();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count13();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count15();

            }
        });

    }

    public void count15() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count15;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count16();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count14();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count16();

            }
        });

    }

    public void count16() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count16;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count17();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count15();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count17();

            }
        });

    }

    public void count17() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count17;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count18();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count16();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count18();

            }
        });

    }

    public void count18() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count18;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count19();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count17();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();

                videoViewCN.stopPlayback();
                count19();

            }
        });

    }

    public void count19() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count19;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                count20();

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count18();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count20();

            }
        });

    }

    public void count20() {

        videoPathCN = "android.resource://" + getPackageName() + "/" + R.raw.count20;
        uriCN = Uri.parse(videoPathCN);
        videoViewCN.setVideoURI(uriCN);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);
          

        videoViewCN.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCN.start();
                
            }
        });


        videoViewCN.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCN.stopPlayback();
                startActivity(new Intent(LessonCounting.this, CountingLessonCongrats.class));

            }
        });

        backbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                count19();

            }
        });

        nextbtnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                
                videoViewCN.stopPlayback();
                startActivity(new Intent(LessonCounting.this, CountingLessonCongrats.class));

            }
        });

    }

    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onUserLeaveHint(){

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                sfx.release();

            }
        });

        videoViewCN.pause();
        currentPosition = videoViewCN.getCurrentPosition();

        super.onUserLeaveHint();

    }

    @Override
    protected void onResume(){

        videoViewCN.seekTo(currentPosition);
        videoViewCN.start();

        super.onResume();

    }

}