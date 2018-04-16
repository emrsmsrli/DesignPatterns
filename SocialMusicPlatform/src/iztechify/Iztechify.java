package iztechify;

import javax.swing.*;

public class Iztechify {
    private JFrame login, fa, fu;
    private int counterU = 0, counterM = 0;

    Iztechify() {
        login = new JFrame("Login");

        JTextField username = new JTextField();
        username.setBounds(50, 230, 200, 40);
        JButton loginB = new JButton("Login");
        loginB.setBounds(250, 230, 100, 40);

        final boolean[] isAdmin = {false};
        loginB.addActionListener(e -> {
            isAdmin[0] = username.getText().equals("admin");
            if (isAdmin[0]) {
                adminProfile();
            } else {
                userProfile(username.getText());
            }
        });

        login.add(username);
        login.add(loginB);
        login.setSize(400, 500);
        login.setLayout(null);
        login.setVisible(true);
    }

    public void adminProfile() {
        fa = new JFrame("Admin Profile");
        fa.setSize(400, 500);
        fa.setLayout(null);
        fa.setVisible(true);
        login.setVisible(false);
    }

    public void userProfile(String user) {
        fu = new JFrame(user + " Profile");

        JTextField searchUser = new JTextField();
        searchUser.setBounds(0, 0, 200, 40);
        JButton addUser = new JButton("Add User");
        addUser.setBounds(200, 0, 100, 40);

        addUser.addActionListener(e -> {
            addNewUser(searchUser.getText());
            counterU++;
        });

        JTextField searchMusic = new JTextField();
        searchMusic.setBounds(500, 0, 200, 40);
        JButton addMusic = new JButton("Add Music");
        addMusic.setBounds(700, 0, 100, 40);

        addMusic.addActionListener(e -> {
            addNewMusic(searchMusic.getText());
            counterM++;
        });

        fu.add(searchUser);
        fu.add(addUser);
        fu.add(searchMusic);
        fu.add(addMusic);
        fu.setSize(800, 800);
        fu.setLayout(null);
        fu.setVisible(true);
    }

    public void addNewUser(String username) {
        // todo: add user staff
        JLabel user = new JLabel();
        user.setBounds(0, 40 + (counterU * 20), 220, 20);
        user.setText("- " + username);

        JButton remove = new JButton("Remove");
        remove.setBounds(220, 40 + (counterU * 20), 80, 20);
        remove.addActionListener(e -> {
            // todo: remove user click
            removeUser(user.getText());
        });

        fu.add(user);
        fu.add(remove);
    }

    public void removeUser(String username) {
        // todo: remove user staff
    }

    public void addNewMusic(String musicName) {
        // todo: add music to playlist staff
        JLabel music = new JLabel();
        music.setBounds(500, 40 + (counterM * 20), 220, 20);
        music.setText("- " + musicName);

        JButton remove = new JButton("Remove");
        remove.setBounds(720, 40 + (counterM * 20), 80, 20);
        remove.addActionListener(e -> {
            // todo: remove music click
            removeMusic(music.getText());
        });

        fu.add(music);
        fu.add(remove);
    }

    public void removeMusic(String musicName) {
        // todo: remove music to playlist staff
    }

    public static void main(String... args) {
        new Iztechify();
    }
}
