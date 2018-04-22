package iztechify.models;

import iztechify.models.music.Album;
import iztechify.models.music.Artist;
import iztechify.models.music.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Music extends Observable {
    private List<Artist> artists;

    public Music(List<Artist> artists) {
        this.artists = new ArrayList<>();
        this.artists.addAll(artists);
    }

    public void remove(Artist artist) {
        artists.remove(artist);
        setChanged();
        notifyObservers(this);
    }

    public void remove(String artist, String album) {
        for (Artist a : artists) {
            if (a.getName().equals(artist)) {
                a.removeAlbum(album);
                setChanged();
                notifyObservers();
                return;
            }
        }
    }

    public void remove(String artist, String album, String song) {
        for (Artist a : artists) {
            if (a.getName().equals(artist)) {
                for (Album al : a.getAlbums()) {
                    if (al.getTitle().equals(album)) {
                        al.removeSong(song);
                        setChanged();
                        notifyObservers();
                        return;
                    }
                }
            }
        }
    }

    public void addArtistToMusic(Artist artist) {
        artists.add(artist);
        setChanged();
        notifyObservers(this);
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public List<Album> getAlbums(String artistName) {
        for (Artist artist : artists) {
            if (artistName.equals(artist.getName()))
                return artist.getAlbums();
        }
        return null;
    }


    public List<Song> getSongs(String artist, String album) {
        for (Artist a : artists)
            if (a.getName().equals(artist))
                return a.getSongs(album);
        return null;
    }
}
