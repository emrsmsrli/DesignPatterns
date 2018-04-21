package iztechify.controllers;

import iztechify.models.Music;


public class AdminController implements Controller {
    private Music music;

    public AdminController(Music music) {
        this.music = music;
    }
}
