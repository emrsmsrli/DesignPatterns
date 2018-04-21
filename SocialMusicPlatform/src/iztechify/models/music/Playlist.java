package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Playlist extends Observable implements Observer {
    private String name;
    private List<Song> songs;

    public Playlist(String name){
        this.name = name;
        songs = new ArrayList<>();
    }

    public boolean addSongToPlaylist(Song song){ // TODO save to json file
        boolean isSuccessful = songs.add(song);
        song.addObserver(this);
        setChanged();
        notifyObservers(this);
        return isSuccessful;
    }

    public boolean removeSongFromPlaylist(Song song){ // TODO save to json file
        boolean isSuccessful = songs.remove(song);
        setChanged();
        notifyObservers(this);
        song.deleteObserver(this);
        return isSuccessful;
    }

    public List<Song> getSongs(){
        return songs;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
