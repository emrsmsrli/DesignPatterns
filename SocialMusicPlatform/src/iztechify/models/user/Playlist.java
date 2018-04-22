package iztechify.models.user;

import iztechify.models.music.Song;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
        /*entries.add(new PlaylistEntry(artist, album, song));
        music.addObserver(this);*/
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    /*public void removeEntry(String artist, String album, String song) {
        entries.removeIf(e -> artist.equals(e.getArtistName())
                && album.equals(e.getAlbumName())
                && song.equals(e.getSongName()));
    }*/

    public String getName() {
        return name;
    }
}
