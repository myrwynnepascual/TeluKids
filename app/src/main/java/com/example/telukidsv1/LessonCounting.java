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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_counting);

        videoViewCX = findViewById(R.id.videoCX);
        backbtnCX = findViewById(R.id.btnbackCX);
        nextbtnCX = findViewById(R.id.nextbtnCX);

        countx();
    }

    public void countx() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.countx;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count1();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonCounting.this, ChooseModeCounting.class));

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count1();

            }
        });
    }

    public void count1() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count1;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count2();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                countx();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count2();

            }
        });
    }

    public void count2() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count2;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count3();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count1();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count3();

            }
        });
    }

    public void count3() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count3;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count4();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count2();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count4();

            }
        });
    }

    public void count4() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count4;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count5();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count3();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count5();

            }
        });
    }

    public void count5() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count5;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count6();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count4();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count6();

            }
        });
    }

    public void count6() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count6;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count7();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count5();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count7();

            }
        });
    }

    public void count7() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count7;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count8();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count6();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count8();

            }
        });
    }

    public void count8() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count8;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count9();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count7();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count9();

            }
        });
    }

    public void count9() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count9;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count10();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count8();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count10();

            }
        });

    }

    public void count10() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count10;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count11();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count9();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count11();

            }
        });

    }

    public void count11() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count11;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count12();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count10();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count12();

            }
        });

    }

    public void count12() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count12;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count13();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count11();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count13();

            }
        });

    }

    public void count13() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count13;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count14();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count12();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count14();

            }
        });

    }

    public void count14() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count14;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count15();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count13();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count15();

            }
        });

    }

    public void count15() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count15;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count16();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count14();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count16();

            }
        });

    }

    public void count16() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count16;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count17();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count15();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count17();

            }
        });

    }

    public void count17() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count17;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count18();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count16();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count18();

            }
        });

    }

    public void count18() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count18;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count19();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count17();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count19();

            }
        });

    }

    public void count19() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count19;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                count20();

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count18();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count20();

            }
        });

    }

    public void count20() {

        videoPathCX = "android.resource://" + getPackageName() + "/" + R.raw.count20;
        uriCX = Uri.parse(videoPathCX);
        videoViewCX.setVideoURI(uriCX);

        mediaController = new MediaController(this);
        videoViewCX.setMediaController(mediaController);
        mediaController.setVisibility(View.GONE);
        mediaController.setAnchorView(videoViewCX);

        videoViewCX.start();

        videoViewCX.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                startActivity(new Intent(LessonCounting.this, CountingLessonCongrats.class));

            }
        });

        backbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count19();

            }
        });

        nextbtnCX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LessonCounting.this, CountingLessonCongrats.class));

            }
        });

    }

}