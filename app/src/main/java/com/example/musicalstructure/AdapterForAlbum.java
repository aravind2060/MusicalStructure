package com.example.musicalstructure;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterForAlbum extends ArrayAdapter<AlbumData>
{
    public AdapterForAlbum(Context context, int resource,List<AlbumData> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        final AlbumData albumData=getItem(position);
        if (convertView==null) {
             convertView = LayoutInflater.from(getContext()).inflate(R.layout.singleviewforgridview, parent, false);
        }
        ImageView imageView=convertView.findViewById(R.id.image_of_album);
        TextView  name_of_album=convertView.findViewById(R.id.tv_name_of_album);
        TextView no_of_songs=convertView.findViewById(R.id.tv_no_of_songs);

        final ImageView  imageView1_options=convertView.findViewById(R.id.image_pop_menu);
        imageView1_options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu=new PopupMenu(getContext(),imageView1_options);
                popupMenu.getMenuInflater().inflate(R.menu.optionsmenu,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                         if(item.getTitle().equals("Play now"))
                         {
                             Intent intent=new Intent(getContext(), MainActivity.ListOfSongsInAlbum.class);
                             intent.putExtra("SongName",albumData.getSongName());
                             intent.putExtra("image",albumData.getImageForSong());
                             getContext().startActivity(intent);
                         }
                         else
                         {
                             Toast.makeText(getContext(), "You have Clicked  "+item.getTitle(), Toast.LENGTH_SHORT).show();
                         }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        imageView.setImageResource(albumData.getImageForSong());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MainActivity.ListOfSongsInAlbum.class);
                intent.putExtra("SongName",albumData.getSongName());
                intent.putExtra("image",albumData.getImageForSong());
                getContext().startActivity(intent);
            }
        });

        name_of_album.setText(albumData.getSongName());
        no_of_songs.setText(String.valueOf(albumData.getNumberOfSongs()));
        return convertView;
    }
}
