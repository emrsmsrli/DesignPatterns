package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Artist extends Observable implements Observer {
    private String name;
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAlbum(Album album){
        this.albums.add(album);
        album.addObserver(this);
        setChanged();
        notifyObservers();
    }

    public List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        for (Album album : albums) {
            songs.addAll(album.getSongs());
        }
        return songs;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
