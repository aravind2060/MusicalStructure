package com.example.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CurrentPlayingSong extends AppCompatActivity {

    TextView current_Song_name,duration_of_current;
    ImageView imageView,play,thumbsup,thumbsdown;
    boolean playing=false,liked=false,disliked=false;
    String duration;
    Toolbar toolbar;
    ImageView previous,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_song);
        toolbar=findViewById(R.id.toolbar_current_playing_song);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Currently Playing");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        current_Song_name=findViewById(R.id.tv_current_Song_name);
         imageView=findViewById(R.id.current_playing_song_image);
         play=findViewById(R.id.control);
         thumbsup=findViewById(R.id.like_button);
         thumbsdown=findViewById(R.id.dislike_button);
         duration_of_current=findViewById(R.id.duration_current_playing_song);
         previous=findViewById(R.id.previous_button);
         next=findViewById(R.id.next_button);

         int imageId=getIntent().getIntExtra("Images",R.drawable.geeta);
         String SongName=getIntent().getStringExtra("SongNames");
         duration=getIntent().getStringExtra("duration");
         final String Track=getIntent().getStringExtra("Track");
        final int position=getIntent().getIntExtra("Position",0);

        current_Song_name.setText(SongName);
        imageView.setImageResource(imageId);
        duration_of_current.setText(duration);

        thumbsup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (liked) {
                    thumbsup.setImageResource(R.drawable.ic_thumb_up_white);
                    thumbsdown.setImageResource(R.drawable.ic_thumb_down_white);
                     liked=false;
                     disliked=true;
                }
                else
                {
                    thumbsup.setImageResource(R.drawable.ic_thumb_up_black);
                    thumbsdown.setImageResource(R.drawable.ic_thumb_down_white);
                    liked=true;
                    disliked=false;
                }
            }
        });
        thumbsdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (disliked) {
                       thumbsdown.setImageResource(R.drawable.ic_thumb_down_white);
                       thumbsup.setImageResource(R.drawable.ic_thumb_up_white);
                       disliked=false;
                       liked=true;
                } else {
                    thumbsdown.setImageResource(R.drawable.ic_thumb_down_black);
                    thumbsup.setImageResource(R.drawable.ic_thumb_up_white);
                      disliked=true;
                      liked=false;
                }
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playing) {
                    play.setImageResource(R.drawable.ic_play_circle);
                    playing=false;
                } else {
                    play.setImageResource(R.drawable.ic_pause_circle);
                    playing=true;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  String current_track=Track;
                    if(current_track.contentEquals("Bahubali"))
                    {
                        String Array_of_songs[]=getResources().getStringArray(R.array.Bahubali_songs);
                        String Array_of_duration[]=getResources().getStringArray(R.array.Bahubali_duration);

                        int nxt_song_index=position+1;

                        if(nxt_song_index==Array_of_songs.length)
                        {
                            nxt_song_index=0;
                            Toast.makeText(getApplicationContext(),"End of Album playing\n Now playing from start",Toast.LENGTH_LONG).show();
                        }

                        String nxt_song_name=Array_of_songs[nxt_song_index];

                        Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                        intent.putExtra("SongNames",nxt_song_name);
                        intent.putExtra("Images",R.drawable.bahubali);
                        intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                        intent.putExtra("Track","Bahubali");
                        intent.putExtra("Position",nxt_song_index);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
               else if(current_track.contentEquals("ArjunReddy"))
                {
                    String Array_of_songs[]=getResources().getStringArray(R.array.Arjun_reddy_songs);
                    String Array_of_duration[]=getResources().getStringArray(R.array.Arjun_reddy_duration);

                    int nxt_song_index=position+1;

                    if(nxt_song_index==Array_of_songs.length)
                    {
                        nxt_song_index=0;
                        Toast.makeText(getApplicationContext(),"End of Album playing\n Now playing from start",Toast.LENGTH_LONG).show();
                    }

                    String nxt_song_name=Array_of_songs[nxt_song_index];

                    Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                    intent.putExtra("SongNames",nxt_song_name);
                    intent.putExtra("Images",R.drawable.arjun);
                    intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                    intent.putExtra("Track","ArjunReddy");
                    intent.putExtra("Position",nxt_song_index);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(current_track.contentEquals("Geeta Govindham"))
                    {
                        String Array_of_songs[]=getResources().getStringArray(R.array.geeta_govindham_songs);
                        String Array_of_duration[]=getResources().getStringArray(R.array.geeta_govindham_duration);

                        int nxt_song_index=position+1;

                        if(nxt_song_index==Array_of_songs.length)
                        {
                            nxt_song_index=0;
                            Toast.makeText(getApplicationContext(),"End of Album playing\n Now playing from start",Toast.LENGTH_LONG).show();
                        }

                        String nxt_song_name=Array_of_songs[nxt_song_index];

                        Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                        intent.putExtra("SongNames",nxt_song_name);
                        intent.putExtra("Images",R.drawable.geeta);
                        intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                        intent.putExtra("Track","Geeta Govindham");
                        intent.putExtra("Position",nxt_song_index);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                else if(current_track.contentEquals("Robo 2.0"))
                    {
                        String Array_of_songs[]=getResources().getStringArray(R.array.Robo_songs);
                        String Array_of_duration[]=getResources().getStringArray(R.array.Robo_duration);

                        int nxt_song_index=position+1;

                        if(nxt_song_index==Array_of_songs.length)
                        {
                            nxt_song_index=0;
                            Toast.makeText(getApplicationContext(),"End of Album playing\n Now playing from start",Toast.LENGTH_LONG).show();
                        }

                        String nxt_song_name=Array_of_songs[nxt_song_index];

                        Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                        intent.putExtra("SongNames",nxt_song_name);
                        intent.putExtra("Images",R.drawable.robo);
                        intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                        intent.putExtra("Track","Robo 2.0");
                        intent.putExtra("Position",nxt_song_index);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                else if(current_track.contentEquals("Spyder"))
                {
                    String Array_of_songs[]=getResources().getStringArray(R.array.Spyder_songs);
                    String Array_of_duration[]=getResources().getStringArray(R.array.Spyder_duration);

                    int nxt_song_index=position+1;

                    if(nxt_song_index==Array_of_songs.length)
                    {
                        nxt_song_index=0;
                        Toast.makeText(getApplicationContext(),"End of Album playing\n Now playing from start",Toast.LENGTH_LONG).show();
                    }

                    String nxt_song_name=Array_of_songs[nxt_song_index];

                    Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                    intent.putExtra("SongNames",nxt_song_name);
                    intent.putExtra("Images",R.drawable.spyder);
                    intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                    intent.putExtra("Track","Spyder");
                    intent.putExtra("Position",nxt_song_index);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(current_track.contentEquals("Na peru surya"))
                    {
                        String Array_of_songs[]=getResources().getStringArray(R.array.na_peru_surya_songs);
                        String Array_of_duration[]=getResources().getStringArray(R.array.na_peru_surya_duration);

                        int nxt_song_index=position+1;

                         if(nxt_song_index==Array_of_songs.length)
                        {
                            nxt_song_index=0;
                            Toast.makeText(getApplicationContext(),"End of Album playing\n Now playing from start",Toast.LENGTH_LONG).show();
                        }

                        String nxt_song_name=Array_of_songs[nxt_song_index];

                        Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                        intent.putExtra("SongNames",nxt_song_name);
                        intent.putExtra("Images",R.drawable.naperu);
                        intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                        intent.putExtra("Track","Na peru surya");
                        intent.putExtra("Position",nxt_song_index);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }


            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String current_track=Track;
                if(current_track.contentEquals("Bahubali"))
                {
                    String Array_of_songs[]=getResources().getStringArray(R.array.Bahubali_songs);
                    String Array_of_duration[]=getResources().getStringArray(R.array.Bahubali_duration);

                    int nxt_song_index=position-1;

                    if(nxt_song_index<=0)
                    {
                        Toast.makeText(getApplicationContext(),"This is starting Song",Toast.LENGTH_LONG).show();
                        return;
                    }

                    String nxt_song_name=Array_of_songs[nxt_song_index];

                    Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                    intent.putExtra("SongNames",nxt_song_name);
                    intent.putExtra("Images",R.drawable.bahubali);
                    intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                    intent.putExtra("Track","Bahubali");
                    intent.putExtra("Position",nxt_song_index);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(current_track.contentEquals("ArjunReddy"))
                {
                    String Array_of_songs[]=getResources().getStringArray(R.array.Arjun_reddy_songs);
                    String Array_of_duration[]=getResources().getStringArray(R.array.Arjun_reddy_duration);

                    int nxt_song_index=position-1;

                    if(nxt_song_index<=0)
                    {
                        Toast.makeText(getApplicationContext(),"This is starting Song",Toast.LENGTH_LONG).show();
                        return;
                    }

                    String nxt_song_name=Array_of_songs[nxt_song_index];

                    Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                    intent.putExtra("SongNames",nxt_song_name);
                    intent.putExtra("Images",R.drawable.arjun);
                    intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                    intent.putExtra("Track","ArjunReddy");
                    intent.putExtra("Position",nxt_song_index);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(current_track.contentEquals("Geeta Govindham"))
                {
                    String Array_of_songs[]=getResources().getStringArray(R.array.geeta_govindham_songs);
                    String Array_of_duration[]=getResources().getStringArray(R.array.geeta_govindham_duration);

                    int nxt_song_index=position-1;

                    if(nxt_song_index<=0)
                    {
                        Toast.makeText(getApplicationContext(),"This is starting Song",Toast.LENGTH_LONG).show();
                        return;
                    }


                    String nxt_song_name=Array_of_songs[nxt_song_index];

                    Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                    intent.putExtra("SongNames",nxt_song_name);
                    intent.putExtra("Images",R.drawable.geeta);
                    intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                    intent.putExtra("Track","Geeta Govindham");
                    intent.putExtra("Position",nxt_song_index);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(current_track.contentEquals("Robo 2.0"))
                {
                    String Array_of_songs[]=getResources().getStringArray(R.array.Robo_songs);
                    String Array_of_duration[]=getResources().getStringArray(R.array.Robo_duration);

                    int nxt_song_index=position-1;

                    if(nxt_song_index<=0)
                    {
                        Toast.makeText(getApplicationContext(),"This is starting Song",Toast.LENGTH_LONG).show();
                        return;
                    }


                    String nxt_song_name=Array_of_songs[nxt_song_index];

                    Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                    intent.putExtra("SongNames",nxt_song_name);
                    intent.putExtra("Images",R.drawable.robo);
                    intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                    intent.putExtra("Track","Robo 2.0");
                    intent.putExtra("Position",nxt_song_index);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(current_track.contentEquals("Spyder"))
                {
                    String Array_of_songs[]=getResources().getStringArray(R.array.Spyder_songs);
                    String Array_of_duration[]=getResources().getStringArray(R.array.Spyder_duration);

                    int nxt_song_index=position-1;

                    if(nxt_song_index<=0)
                    {
                        Toast.makeText(getApplicationContext(),"This is starting Song",Toast.LENGTH_LONG).show();
                        return;
                    }


                    String nxt_song_name=Array_of_songs[nxt_song_index];

                    Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                    intent.putExtra("SongNames",nxt_song_name);
                    intent.putExtra("Images",R.drawable.spyder);
                    intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                    intent.putExtra("Track","Spyder");
                    intent.putExtra("Position",nxt_song_index);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(current_track.contentEquals("Na peru surya"))
                {
                    String Array_of_songs[]=getResources().getStringArray(R.array.na_peru_surya_songs);
                    String Array_of_duration[]=getResources().getStringArray(R.array.na_peru_surya_duration);

                    int nxt_song_index=position-1;

                    if(nxt_song_index<=0)
                    {
                        Toast.makeText(getApplicationContext(),"This is starting Song",Toast.LENGTH_LONG).show();
                        return;
                    }


                    String nxt_song_name=Array_of_songs[nxt_song_index];

                    Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                    intent.putExtra("SongNames",nxt_song_name);
                    intent.putExtra("Images",R.drawable.naperu);
                    intent.putExtra("duration",Array_of_duration[nxt_song_index]);
                    intent.putExtra("Track","Na peru surya");
                    intent.putExtra("Position",nxt_song_index);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });

    }

}
