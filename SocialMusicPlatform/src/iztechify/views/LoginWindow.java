package iztechify.views;

import javax.swing.*;

public class LoginWindow extends AbstractWindow {
    private JFrame login;

    public LoginWindow() {
        super("Login");
        login = new JFrame("Login");

        JTextField username = new JTextField();
        username.setBounds(50, 230, 200, 40);
        JButton loginB = new JButton("Login");
        loginB.setBounds(250, 230, 100, 40);

        loginB.addActionListener(e -> {
            if (username.getText().equals("admin")) {
                new AdminWindow();
                login.setVisible(false);
            } else {
                new UserWindow(username.getText());
            }
        });

        login.add(username);
        login.add(loginB);
        login.setSize(400, 500);
        login.setLayout(null);
        login.setVisible(true);

    }

}
