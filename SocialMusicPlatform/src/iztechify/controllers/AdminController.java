package iztechify.controllers;

import iztechify.models.Music;
import iztechify.models.music.Album;
import iztechify.models.music.Artist;
import iztechify.models.music.Song;
import iztechify.util.GSON;


public class AdminController implements Controller {
    private Music music;

    public AdminController(Music music) {
        this.music = music;
    }

    public void remove(String artist) {
        for (Artist a : music.getArtists()) {
            if (a.getName().equals(artist)) {
                music.remove(a);
                return;
            }
        }
    }

    public void remove(String artist, String album) {
        music.remove(artist, album);
    }

    public void remove(String artist, String album, String song) {
        music.remove(artist, album, song);

    }

    public void newArtist() {
        // todo: new window to ask artist name
        music.addArtist(new Artist(name));
    }

    public void newAlbum() {
        // todo: new window to ask album title and description and return with artist name
        for (Artist a : music.getArtists()) {
            if (a.getName().equals(artistName)) {
                a.addAlbum(new Album(title, description));
                return;
            }
        }
    }

    public void newSong() {
        // todo: new window to ask song title and length return with artistName and albumTitle
        for (Artist a : music.getArtists()) {
            if (a.getName().equals(artistName)) {
                for (Album al : a.getAlbums()) {
                    if (al.getTitle().equals(albumTitle)) {
                        al.addSong(new Song(title, length));
                    }
                }
            }
        }

    }
}
