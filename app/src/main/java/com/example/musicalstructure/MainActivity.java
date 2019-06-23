package com.example.musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<AlbumData> albumDataArrayList=new ArrayList<>();

        albumDataArrayList.add(new AlbumData("Bahubali",R.drawable.bahubali,getResources().getStringArray(R.array.Bahubali_songs).length+" Songs"));
        albumDataArrayList.add(new AlbumData("Robo 2.0",R.drawable.robo,getResources().getStringArray(R.array.Robo_songs).length+" Songs"));
        albumDataArrayList.add(new AlbumData("ArjunReddy",R.drawable.arjun,getResources().getStringArray(R.array.Arjun_reddy_songs).length+" Songs"));
        albumDataArrayList.add(new AlbumData("Geeta Govindham",R.drawable.geeta,getResources().getStringArray(R.array.geeta_govindham_songs).length+" Songs"));
        albumDataArrayList.add(new AlbumData("Na peru surya",R.drawable.naperu,getResources().getStringArray(R.array.na_peru_surya_songs).length+" Songs"));
        albumDataArrayList.add(new AlbumData("Spyder",R.drawable.spyder,getResources().getStringArray(R.array.Spyder_songs).length+" Songs"));

        AdapterForAlbum adapterForAlbum=new AdapterForAlbum(getApplicationContext(),R.layout.singleviewforgridview,albumDataArrayList);
        GridView gridView=findViewById(R.id.gridview);
        gridView.setAdapter(adapterForAlbum);
    }

    public static class ListOfSongsInAlbum extends AppCompatActivity {


        ListView listView;
        ArrayList<ListOfSongs>listOfSongsArrayList;
        Toolbar toolbar;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_of_songs_in_album);

            toolbar=findViewById(R.id.toolbar_list_of_songs_in_album);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("List of Songs In this Album");
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            listView=findViewById(R.id.list_view_list_of_songs_in_album);

             listOfSongsArrayList=new ArrayList<>();

            String AlbumName=getIntent().getStringExtra("SongName");
            int  ImageId=getIntent().getIntExtra("image",R.drawable.bahubali);
             chk(AlbumName,ImageId);

            CustomAdapter customAdapter=new CustomAdapter(this,R.layout.singleviewforlistofsongs,listOfSongsArrayList);
            listView.setAdapter(customAdapter);
        }

        public void chk(String AlbumName,int ImageId)
        {
            listOfSongsArrayList.clear();
              switch (AlbumName)
              {
                  case "Bahubali":
                      String[] songs=getResources().getStringArray(R.array.Bahubali_songs);
                      String[] songs_duration=getResources().getStringArray(R.array.Bahubali_duration);
                      for (int i=0;i<songs.length;i++)
                      {
                          listOfSongsArrayList.add(new ListOfSongs(ImageId,songs[i],songs_duration[i],"Bahubali",i));
                      }
                      break;
                  case "Robo 2.0":
                      String[] songss=getResources().getStringArray(R.array.Robo_songs);
                      String[] songs_durations=getResources().getStringArray(R.array.Robo_duration);
                      for (int i=0;i<songss.length;i++)
                      {
                          listOfSongsArrayList.add(new ListOfSongs(ImageId,songss[i],songs_durations[i],"Robo 2.0",i));
                      }
                      break;
                  case "ArjunReddy":
                      String[] songsss=getResources().getStringArray(R.array.Arjun_reddy_songs);
                      String[] songs_durationsss=getResources().getStringArray(R.array.Arjun_reddy_duration);
                      for (int i=0;i<songsss.length;i++)
                      {
                          listOfSongsArrayList.add(new ListOfSongs(ImageId,songsss[i],songs_durationsss[i],"ArjunReddy",i));
                      }
                      break;
                  case "Spyder":
                      String[] songse=getResources().getStringArray(R.array.Spyder_songs);
                      String[] songs_duratione=getResources().getStringArray(R.array.Spyder_duration);
                      for (int i=0;i<songse.length;i++)
                      {
                          listOfSongsArrayList.add(new ListOfSongs(ImageId,songse[i],songs_duratione[i],"Spyder",i));
                      }
                      break;
                  case "Na peru surya":
                      String[] songsee=getResources().getStringArray(R.array.na_peru_surya_songs);
                      String[] songs_durationee=getResources().getStringArray(R.array.na_peru_surya_duration);
                      for (int i=0;i<songsee.length;i++)
                      {
                          listOfSongsArrayList.add(new ListOfSongs(ImageId,songsee[i],songs_durationee[i],"Na peru surya",i));
                      }
                      break;
                  case "Geeta Govindham":
                      String[] songsr=getResources().getStringArray(R.array.geeta_govindham_songs);
                      String[] songs_durationr=getResources().getStringArray(R.array.geeta_govindham_duration);
                      for (int i=0;i<songsr.length;i++)
                      {
                          listOfSongsArrayList.add(new ListOfSongs(ImageId,songsr[i],songs_durationr[i],"Geeta Govindham",i));
                      }
                      break;

              }
        }




        class CustomAdapter extends ArrayAdapter<ListOfSongs>
        {

            public CustomAdapter(Context context, int resource, List<ListOfSongs> objects) {
                super(context, resource, objects);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                final ListOfSongs listOfSongs=getItem(position);
                if (convertView==null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.singleviewforlistofsongs, parent, false);
                }
                RelativeLayout relativeLayout=convertView.findViewById(R.id.whole_item_list_of_songs);
                ImageView imageView=convertView.findViewById(R.id.image_of_list_of_songs);
                TextView songName=convertView.findViewById(R.id.tv_name_of_list_of_songs);
                TextView duration=convertView.findViewById(R.id.tv_duration);
                ImageView playbutton=convertView.findViewById(R.id.play_button_list_of_songs);

                imageView.setImageResource(listOfSongs.getImage());
                songName.setText(listOfSongs.getSongName());
                duration.setText(listOfSongs.getLengthOfSong());

                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                        intent.putExtra("Images",listOfSongs.getImage());
                        intent.putExtra("SongNames",listOfSongs.getSongName());
                        intent.putExtra("duration",listOfSongs.getLengthOfSong());
                        intent.putExtra("Track",listOfSongs.getTrack());
                        intent.putExtra("Position",listOfSongs.getPosition());
                        getContext().startActivity(intent);
                    }
                });
                playbutton.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent intent=new Intent(getApplicationContext(),CurrentPlayingSong.class);
                         intent.putExtra("Images",listOfSongs.getImage());
                         intent.putExtra("SongNames",listOfSongs.getSongName());
                         intent.putExtra("duration",listOfSongs.getLengthOfSong());
                          intent.putExtra("Track",listOfSongs.getTrack());
                          intent.putExtra("Position",listOfSongs.getPosition());
                         getContext().startActivity(intent);
                     }
                 });
                return convertView;
            }

        }
    }
}

