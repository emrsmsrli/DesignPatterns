package iztechify.views;

import javax.swing.*;

public class LoginWindow extends AbstractWindow {
    public LoginWindow() {
        super("Login");

        JTextField username = new JTextField();
        username.setBounds(50, 230, 200, 40);
        JButton loginB = new JButton("Login");
        loginB.setBounds(250, 230, 100, 40);

        loginB.addActionListener(e -> {
            if (username.getText().equals("admin")) {
                new AdminWindow(); // todo register windows to admin controller
            } else {
                new UserWindow(username.getText());
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
}
