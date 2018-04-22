package iztechify.controllers;

import iztechify.models.Users;
import iztechify.models.user.User;
import iztechify.models.Music;
import iztechify.views.AdminWindow;
import iztechify.views.UserWindow;
import iztechify.views.Window;

import javax.swing.*;

public class LoginController {
    private Music music;
    private Users users;

    public LoginController(Music music, Users users) {
        this.music = music;
        this.users = users;
    }

    public void signup(String username) {
        if(username.equals("admin"))
            return;

        User user = users.getUser(username);
        if(user != null) {
            JOptionPane.showMessageDialog(null,
                    "User already exist!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        users.addUser(username);
        JOptionPane.showMessageDialog(null, username + " registered");
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
        music.addObserver(adminWindow);
        adminWindow.showWindow();
    }

    private void loginUser(String username) {
        User user = users.getUser(username);
        if (user == null) {
            JOptionPane.showMessageDialog(null,
                    "User does not exist!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        UserController userController = new UserController(users, user);
        Window userWindow = new UserWindow(user.getUsername(), userController);
        users.addObserver(userWindow);
        userWindow.showWindow();
    }
}
