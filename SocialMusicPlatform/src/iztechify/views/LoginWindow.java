package iztechify.views;

import iztechify.controllers.LoginController;
import iztechify.models.Music;

import javax.swing.*;
import java.util.Observable;

public class LoginWindow extends AbstractWindow {
    private LoginController loginController; // todo: Controller or LoginController ?

    public LoginWindow(Music music, LoginController loginController) {
        super("Login");
        this.loginController = loginController;

        JTextField username = new JTextField();
        username.setBounds(50, 230, 200, 40);
        JButton loginB = new JButton("Login");
        loginB.setBounds(250, 230, 100, 40);

        loginB.addActionListener(e -> {
            if (username.getText().equals("admin")) {
                this.loginController.loginAdmin(); // todo register windows to admin controller
            } else {
                this.loginController.loginUser(username.getText());
            }
        });

        add(username);
        add(loginB);
        setSize(400, 500);
    }

    @Override
    public void showWindow() {
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
