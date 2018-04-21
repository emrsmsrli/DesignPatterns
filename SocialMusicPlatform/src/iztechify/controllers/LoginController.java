package iztechify.controllers;

import iztechify.models.User;
import iztechify.models.music.Music;
import iztechify.views.AdminWindow;
import iztechify.views.Window;

import java.util.List;

public class LoginController implements Controller {
    private Music music;
    private List<User> users;

    public LoginController(Music music, List<User> users) {
        this.music = music;
        this.users = users;
    }

    public void loginAdmin() {
        Controller adminController = new AdminController(music);
        Window adminWindow = new AdminWindow(adminController, music);
        adminWindow.showWindow();
    }

    public void loginUser(String username) {
        User user = getUser(username);
        if(user == null) {
            // todo alert dialog user does not exits
            return;
        }

        // todo user controller and view
    }

    private User getUser(String username) {
        for(User user : users)
            if(user.getUsername().equals(username))
                return user;
        return null;
    }
}
