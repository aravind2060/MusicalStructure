package com.example.musicalstructure;

public class AlbumData {
    private String SongName="";
    private int ImageForSong=0;
    private String NumberOfSongs="";

    public AlbumData(String songName, int imageForSong,String numberOfSongs) {
        SongName = songName;
        ImageForSong = imageForSong;
        NumberOfSongs=numberOfSongs;
    }

    public int getImageForSong() {
        return ImageForSong;
    }

    public void setImageForSong(int imageForSong) {
        ImageForSong = imageForSong;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public String getNumberOfSongs() {
        return NumberOfSongs;
    }

    public void setNumberOfSongs(String numberOfSongs) {
        NumberOfSongs = numberOfSongs;
    }
}
