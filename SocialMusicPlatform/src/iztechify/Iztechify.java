package iztechify;

import iztechify.controllers.LoginController;
import iztechify.controllers.UserController;
import iztechify.models.Users;
import iztechify.models.Music;
import iztechify.models.music.Artist;
import iztechify.models.user.User;
import iztechify.util.GSON;
import iztechify.views.LoginWindow;
import iztechify.views.UserWindow;
import iztechify.views.Window;

import javax.swing.*;
import java.util.Arrays;

public class Iztechify {
    public static void main(String... args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        //Models
        Music music = new Music(Arrays.asList(GSON.loadMusic()));
        Users users = new Users(Arrays.asList(GSON.loadUsers()));
        User user = new User("ben");

        //Controllers
        LoginController loginController = new LoginController(music, users);
        UserController userController = new UserController(users, new User("fafa"));

        //Windows
        Window loginWindow = new LoginWindow(music, loginController);
        UserWindow w = new UserWindow("fafa" ,userController);

        //Adding observers to observables
        user.addObserver(w);
        music.addObserver(w);

        user.setUsername("Bagator");
        music.addArtistToMusic(new Artist("fanfa"));

        loginWindow.showWindow();
    }
}
