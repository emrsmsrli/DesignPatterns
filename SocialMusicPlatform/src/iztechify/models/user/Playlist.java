package iztechify.models.user;

import iztechify.models.Music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Playlist extends Observable implements Observer {
    private String name;
    private List<PlaylistEntry> entries;

    public Playlist(String name) {
        this.name = name;
        entries = new ArrayList<>();
    }

    public List<PlaylistEntry> getEntries() {
        return entries;
    }

    public void addSong(Music music, String artist, String album, String song) {
        entries.add(new PlaylistEntry(artist, album, song));
        music.addObserver(this);
        setChanged();
        notifyObservers();
    }

    public void removeEntry(String artist, String album, String song) {
        entries.removeIf(e -> artist.equals(e.getArtistName())
                && album.equals(e.getAlbumName())
                && song.equals(e.getSongName()));
        setChanged();
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        // todo check music, ideally through `arg`, change oneself and notify observers if changed
    }
}
