package iztechify.models.user;

import iztechify.models.music.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Playlist extends Observable {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
        setChanged();
        notifyObservers();
    }

    public void removeSong(Song song) {
        songs.remove(song);
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

}
