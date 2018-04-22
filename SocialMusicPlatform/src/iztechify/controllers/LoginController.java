package iztechify.controllers;

import iztechify.models.Users;
import iztechify.models.user.User;
import iztechify.models.Music;
import iztechify.views.AdminWindow;
import iztechify.views.UserWindow;
import iztechify.views.Window;

import javax.swing.*;

public class LoginController implements Controller {
    private Music music;
    private Users users;

    public LoginController(Music music, Users users) {
        this.music = music;
        this.users = users;
    }

    public void createUser(String username){
        // todo: add user to json
    }

    public void login(String username) {
        if (username.equals("admin")) {
            loginAdmin();
        } else {
            loginUser(username);
        }
    }

    private void loginAdmin() {
        AdminController adminController = new AdminController(music);
        Window adminWindow = new AdminWindow(adminController, music);
        adminWindow.showWindow();
    }

    private void loginUser(String username) {
        User user = getUser(username);
        if (user == null) {
            JOptionPane.showMessageDialog(null, "User does not exist!");
            return;
        }
        UserController userController = new UserController(users, user);
        Window userWindow = new UserWindow(user.getUsername(), userController); // todo: get observables from where?
        userWindow.showWindow();
    }

    private User getUser(String username) {
        for (User user : users.getUsers())
            if (user.getUsername().equals(username))
                return user;
        return null;
    }
}
