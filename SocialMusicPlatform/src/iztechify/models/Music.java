package iztechify.models;

import iztechify.models.music.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Music extends Observable  {
    private List<Artist> artists;

    public Music(List<Artist> artists) {
        this.artists = new ArrayList<>();
        this.artists.addAll(artists);
    }

    public boolean addArtistToMusic(Artist artist){
        boolean isSuccessful = artists.add(artist);
        setChanged();
        notifyObservers();
        return isSuccessful;
    }

    public boolean removeArtistFromMusic(Artist artist){
        boolean isSuccessful = artists.remove(artist);
        setChanged();
        notifyObservers();
        return isSuccessful;
    }

    public void read() { // TODO read from json file

    }

    public void write() { // TODO write changes to json file

    }
}
