package iztechify.controllers;

import iztechify.models.Users;
import iztechify.models.user.User;
import iztechify.models.Music;
import iztechify.views.AdminWindow;
import iztechify.views.Window;

public class LoginController implements Controller {
    private Music music;
    private Users users;

    public LoginController(Music music, Users users) {
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
        for(User user : users.getUsers())
            if(user.getUsername().equals(username))
                return user;
        return null;
    }
}
