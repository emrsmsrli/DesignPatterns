package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String title;
    private String description;
    private List<Song> songs;

    public Album(String title, String description) {
        this.title = title;
        this.description = description;
        this.songs = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(String name) {
        Song s = null;
        for(Song song : songs)
            if(song.getTitle().equals(name)) {
                s = song;
                break;
            }
        if(s != null)
            songs.remove(s);
    }
}
