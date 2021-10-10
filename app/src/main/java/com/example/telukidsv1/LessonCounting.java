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

    VideoView videoViewCX;
    String videoPathCX;
    Uri uriCX;
    ImageButton backbtnCX, nextbtnCX;
    MediaController mediaController;
    MediaPlayer sfx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_counting);

        videoViewCX = findViewById(R.id.videoCX);
        backbtnCX = findViewById(R.id.btnbackCX);
        nextbtnCX = findViewById(R.id.nextbtnCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        BackgroundSoundService.onPause();

        countx();
    }

    public void countx() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.countx;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();

            }
        });

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count1();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                startActivity(new Intent(LessonCounting.this, ChooseModeCounting.class));

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count1();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count1() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count1;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count2();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                countx();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count2();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count2() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count2;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count3();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count1();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count3();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count3() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count3;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count4();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count2();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count4();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count4() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count4;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count5();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count3();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count5();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count5() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count5;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count6();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count4();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count6();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count6() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count6;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count7();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count5();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count7();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count7() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count7;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count8();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count6();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count8();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count8() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count8;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count9();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count7();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count9();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count9() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count9;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count10();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count8();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count10();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count10() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count10;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count11();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count9();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count11();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count11() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count11;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count12();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count10();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count12();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count12() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count12;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count13();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count11();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count13();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count13() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count13;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count14();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count12();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count14();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count14() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count14;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count15();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count13();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count15();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count15() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count15;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count16();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count14();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count16();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count16() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count16;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count17();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count15();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count17();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count17() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count17;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count18();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count16();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count18();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count18() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count18;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count19();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count17();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count19();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count19() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count19;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                count20();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count18();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count20();

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

    public void count20() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count20;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);
        sfx = MediaPlayer.create(this, R.raw.btnsfx);    

        videoViewCX.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

                videoViewCX.start();
                
            }
        });


        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                videoViewCX.stopPlayback();
                startActivity(new Intent(LessonCounting.this, CountingLessonCongrats.class));

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                count19();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sfx.start();
                videoViewCX.stopPlayback();
                startActivity(new Intent(LessonCounting.this, CountingLessonCongrats.class));

            }
        });

        sfx.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sfx.release();
            }
        });

    }

}