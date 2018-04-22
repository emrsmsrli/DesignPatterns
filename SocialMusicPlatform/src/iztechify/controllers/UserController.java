package iztechify.controllers;

import iztechify.models.Users;
import iztechify.models.user.Playlist;
import iztechify.models.user.User;

import javax.swing.*;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import static javax.swing.JOptionPane.CLOSED_OPTION;

public class UserController {
    private Users allUsers;
    private User thisUser;

    public UserController(Users allUsers, User thisUser) {
        this.allUsers = allUsers;
        this.thisUser = thisUser;
    }

    public void addFriend() {
        List<String> usernames = allUsers.getUsers().stream()
                .map(User::getUsername).collect(Collectors.toList());
        usernames.remove(thisUser.getUsername());
        usernames.removeAll(thisUser.getFriends());

        if(usernames.isEmpty())
            return;

        Object[] options = usernames.toArray();

        int selection = JOptionPane.showOptionDialog(null,
                "Select a user",
                "Add new friend",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );
        if(selection == CLOSED_OPTION)
            return;

        allUsers.befriend(thisUser.getUsername(), (String) options[selection]);
    }

    public List<String> getFriends() {
        return thisUser.getFriends();
    }

    public String addPlaylist() {
        String name = JOptionPane.showInputDialog("Select playlist name");
        if(name == null)
            return null;

        if(thisUser.getPlaylist(name) != null) {
            JOptionPane.showMessageDialog(null, "Playlist already exists");
            return null;
        }

        allUsers.addPlaylist(thisUser, name);
        return name;
    }

    public void addSong() {
        
    }

    public void removeSong(String playlist, Vector songData) {

    }

    public User getThisUser() {
        return thisUser;
    }

    public List<Playlist> getPlaylists() {
        return thisUser.getPlaylists();
    }

    public Playlist getPlaylist(String name) {
        return thisUser.getPlaylist(name);
    }

    public List<Playlist> getFriendPlaylists(String username) {
        return allUsers.getUser(username).getPlaylists();
    }

    public Playlist getFriendPlaylist(String username, String playlistName) {
        return allUsers.getUser(username).getPlaylist(playlistName);
    }
}
