package iztechify.models.music;

import java.util.List;
import java.util.Observable;

public class Music extends Observable  {
    private List<Artist> artists;

    public Music(List<Artist> artists) {
        this.artists = artists;
    }

    public boolean addArtistToMusic(Artist artist){
        boolean isSuccessful = artists.add(artist);
        notifyObservers();
        return isSuccessful;
    }

    public boolean removeArtistFromMusic(Artist artist){
        boolean isSuccessful = artists.remove(artist);
        notifyObservers();
        return isSuccessful;
    }

    public void read() { // TODO read from json file

    }

    public void write() { // TODO write changes to json file

    }
}
