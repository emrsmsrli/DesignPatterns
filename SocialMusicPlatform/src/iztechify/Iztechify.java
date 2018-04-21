package iztechify;

import iztechify.controllers.LoginController;
import iztechify.models.User;
import iztechify.models.music.Music;
import iztechify.util.GSON;
import iztechify.views.LoginWindow;
import iztechify.views.Window;

import java.util.Arrays;
import java.util.List;

public class Iztechify {
    public static void main(String... args) {
        Music music = new Music(Arrays.asList(GSON.loadMusic()));
        List<User> users = Arrays.asList(GSON.loadUsers());
        LoginController loginController = new LoginController(music, users);
        Window loginWindow = new LoginWindow(music, loginController);
        loginWindow.showWindow();
    }
}
