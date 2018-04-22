package iztechify.controllers;

import iztechify.models.Users;
import iztechify.models.user.Playlist;
import iztechify.models.user.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static javax.swing.JOptionPane.CLOSED_OPTION;

public class UserController {
    private Users allUsers;
    private User thisUser;

    public UserController(Users allUsers, User thisUser) {
        this.allUsers = allUsers;
        this.thisUser = thisUser;
    }

    public void addFriend() {
        List<User> users = new ArrayList<>(allUsers.getUsers());
        users.remove(thisUser);
        Object[] options = new Object[users.size()];
        for(int i = 0; i < options.length; i++)
            options[i] = users.get(i).getUsername();

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

    public void addPlaylist() {
        String name = JOptionPane.showInputDialog("Select playlist name");
        if(name == null)
            return;

        allUsers.addPlaylist(thisUser, name);
    }

    public void addSong() {

    }

    public void removeSong(String playlist, Vector songData) {

    }

    /* todo change these to create dialogs and ask info
    public boolean addFriend(String username) {
        if(thisUser.getFriend(username) != null)
            return false;

        User u = allUsers.getUser(username);
        if(u == null)
            return false;

        thisUser.addFriend(u);
        return true;
    }

    public boolean addPlaylist(String name) {
        if(thisUser.getPlaylist(name) != null)
            return false;

        thisUser.addPlaylist(new Playlist(name));
        return true;
    }*/

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
