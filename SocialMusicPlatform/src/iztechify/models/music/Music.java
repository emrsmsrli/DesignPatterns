package iztechify.models.music;

import java.util.List;
import java.util.Observable;

public class Music extends Observable  {
    private List<Artist> artists;

    public Music(List<Artist> artists) {
        this.artists = artists;
    }

    public void read() {

    }

    public void write() {

    }
}
