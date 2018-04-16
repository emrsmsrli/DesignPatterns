package iztechify;

import iztechify.views.AbstractWindow;
import iztechify.views.LoginWindow;

import javax.swing.*;

public class Iztechify {
    public static void main(String... args) {
        AbstractWindow w = new LoginWindow();
        w.setBounds(0, 0, 100, 100);
        w.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        w.setVisible(true);
        // TODO create one logincontroller and loginwindow
        // TODO create usercontrollers and views
    }
}
