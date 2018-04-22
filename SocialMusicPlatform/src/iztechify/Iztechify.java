package iztechify;

import iztechify.controllers.LoginController;
import iztechify.models.Users;
import iztechify.models.Music;
import iztechify.util.GSON;
import iztechify.views.LoginWindow;
import iztechify.views.Window;

import javax.swing.*;

public class Iztechify {
    public static void main(String... args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //Models
        Music music = new Music(GSON.get().loadMusic());
        Users users = new Users(GSON.get().loadUsers());
        music.addObserver(GSON.get());
        users.addObserver(GSON.get());

        //Controllers
        LoginController loginController = new LoginController(music, users);

        //Views
        Window loginWindow = new LoginWindow(loginController);

        loginWindow.showWindow();
    }
}
