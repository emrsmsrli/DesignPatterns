package iztechify.controllers;

import iztechify.models.Music;
import iztechify.models.music.Song;


public class AdminController implements Controller {
    private Music music;

    public AdminController(Music music) {
        this.music = music;
    }

    public boolean addNewSongToGSON(Song song) {
        return true;
    }

    public boolean removeSongFromGGSON(Song song) {
        return true;
    }

    public boolean editMusicInGGSON(Song song) {
        return true;
    }
}
