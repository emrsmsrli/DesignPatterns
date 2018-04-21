package iztechify.controllers;

import iztechify.models.music.Music;
import iztechify.views.AdminWindow;
import iztechify.views.Window;

public class LoginController implements Controller {

    private Music music;

    public LoginController(Music music) {
        this.music = music;
    }

    public void loginAdmin() {
        Controller adminController = new AdminController(music);
        Window adminWindow = new AdminWindow(adminController, music);
        adminWindow.showWindow();
    }

    public void loginUser() {

    }

}
