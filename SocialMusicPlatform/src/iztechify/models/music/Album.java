package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Album extends Observable implements Observer{
    private String title;
    private String description;

    private List<Song> songs;

    public Album(String title, String description) {
        this.title = title;
        this.description = description;
        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Song> getSongs() {
        return songs;
    }

    // todo: adding songs to album should be inside the update method because adding songs belongs to admin

//    public boolean addSongToAlbum(Song song){ // TODO save to json file
//        boolean isSuccessful = songs.add(song);
//        song.addObserver(this);
//        setChanged();
//        notifyObservers(this);
//        return isSuccessful;
//    }
//
//    public boolean removeSong(Song song){ // TODO save to json file
//        boolean isSuccessful = songs.remove(song);
//        setChanged();
//        notifyObservers(this);
//        song.deleteObserver(this);
//        return isSuccessful;
//    }

    @Override
    public void update(Observable o, Object arg) {
        //todo: add song to songs list here
    }
}
