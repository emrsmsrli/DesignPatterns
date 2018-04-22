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
        for(Album album : albums)
            songs.addAll(album.getSongs());
        return songs;
    }

    public List<Song> getSongs(String album) {
        for (Album a : albums)
            if(a.getTitle().equals(album))
                return a.getSongs();
        return null;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
