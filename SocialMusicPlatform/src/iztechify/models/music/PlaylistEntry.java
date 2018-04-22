package iztechify.models.music;

import java.util.Observable;
import java.util.Observer;

public class PlaylistEntry extends Observable implements Observer {
    private String artistName;
    private String albumName;
    private Song song;

    PlaylistEntry(String artistName, String albumName, Song song) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }


    @Override
    public void update(Observable o, Object arg) {
        // todo: if a song, artist or album edited then update the entry information
    }

}
