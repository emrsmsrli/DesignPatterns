package iztechify;

import iztechify.controllers.LoginController;
import iztechify.models.music.Music;
import iztechify.views.LoginWindow;
import iztechify.views.Window;

public class Iztechify {
    public static void main(String... args) {
        Music music = new Music();
        LoginController loginController = new LoginController(music);
        Window loginWindow = new LoginWindow(music, loginController);
        loginWindow.showWindow();
    }
}
