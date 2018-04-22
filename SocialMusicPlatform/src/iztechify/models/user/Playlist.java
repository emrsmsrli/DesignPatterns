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

    public void removeSong(Object[] data) {
        Song s = null;
        for(Song song : songs) {
            if(song.getTitle().equals(data[0])
                    && song.getAlbum().getTitle().equals(data[1])
                    && song.getAlbum().getArtist().getName().equals(data[2])) {
                s = song;
                break;
            }
        }
        if(s != null) {
            songs.remove(s);
            setChanged();
            notifyObservers();
        }
    }

    public String getName() {
        return name;
    }

}
