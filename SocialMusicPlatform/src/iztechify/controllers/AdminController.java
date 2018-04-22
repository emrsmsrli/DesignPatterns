package iztechify.controllers;

import iztechify.models.Music;
import iztechify.models.music.Artist;
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
                GSON.saveMusic(music.getArtists());
                return;
            }
        }
    }

    public void remove(String artist, String album) {
        music.remove(artist, album);
        GSON.saveMusic(music.getArtists());
    }

    public void remove(String artist, String album, String song) {
        music.remove(artist, album, song);
        GSON.saveMusic(music.getArtists());

    }

    public void newArtist() {
    }

    public void newAlbum() {
    }

    public void newSong() {

    }
}
