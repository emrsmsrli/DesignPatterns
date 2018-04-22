package iztechify.controllers;

import iztechify.models.Music;


public class AdminController implements Controller {
    private Music music;

    public AdminController(Music music) {
        this.music = music;
    }

    public boolean addNewMusicToGSON(Music music) {
        return true;
    }

    public boolean removeMusicFromGGSON() {
        return true;
    }

    public boolean editMusicInGGSON(Music music) {
        return true;
    }
}
