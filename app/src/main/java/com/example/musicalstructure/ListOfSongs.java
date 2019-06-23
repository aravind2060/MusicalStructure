package com.example.musicalstructure;

public class ListOfSongs {

   private int Image;
    private String SongName;
   private String LengthOfSong;
   private String Track;
   private int Position;

    public ListOfSongs(int image, String songName, String lengthOfSong,String Track,int position) {
        Image = image;
        SongName = songName;
        LengthOfSong = lengthOfSong;
        this.Track=Track;
        this.Position=position;
    }

    public void setTrack(String t)
    {
        Track=t;
    }
    public String getTrack()
    {
        return Track;
    }
    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public String getLengthOfSong() {
        return LengthOfSong;
    }

    public void setLengthOfSong(String lengthOfSong) {
        LengthOfSong = lengthOfSong;
    }
   public void setPosition(int position)
   {
       this.Position=position;
   }
   public int getPosition()
   {
       return Position;
   }
}
