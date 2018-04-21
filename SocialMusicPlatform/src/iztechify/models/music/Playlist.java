package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Playlist extends Observable {
    private String name;
    private List<Song> songs;

    public Playlist(String name){
        this.name = name;
        songs = new ArrayList<>();
    }

    public boolean addSongToPlaylist(Song song){ // TODO save to json file
        boolean isSuccessful = songs.add(song);
        notifyObservers();
        return isSuccessful;
    }

    public boolean removeSongFromPlaylist(Song song){ // TODO save to json file
        boolean isSuccessful = songs.remove(song);
        notifyObservers();
        return isSuccessful;
    }

    public String getName() {
        return name;
    }
}
