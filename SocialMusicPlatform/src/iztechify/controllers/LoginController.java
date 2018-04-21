package iztechify.controllers;

import iztechify.models.User;
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

    public void loginUser(String username) {
        User user = getUser(username);

    }

    private User getUser(String username) {
        // todo: search user on the database and return user object
        return username == null ? new User("") : new User(username);
    }

}
