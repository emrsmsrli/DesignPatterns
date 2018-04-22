package iztechify.controllers;

import iztechify.models.Music;
import iztechify.models.Users;
import iztechify.models.user.Playlist;
import iztechify.models.user.User;
import iztechify.views.ChooseSongDialog;

import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

import static javax.swing.JOptionPane.CLOSED_OPTION;

public class UserController {
    private Music music;
    private Users allUsers;
    private User thisUser;

    public UserController(Music music, Users allUsers, User thisUser) {
        this.music = music;
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

    public void addPlaylist() {
        String name = JOptionPane.showInputDialog("Select playlist name");
        if(name == null)
            return;

        if(thisUser.getPlaylist(name) != null) {
            JOptionPane.showMessageDialog(null, "Playlist already exists");
            return;
        }

        allUsers.addPlaylist(thisUser, name);
    }

    public void addSong(String playlist) {
        ChooseSongDialog dialog = new ChooseSongDialog(music.getSongs(), data -> {
            allUsers.addSongToPlaylist(music, thisUser, playlist, data);
        });
        dialog.pack();
        dialog.setVisible(true);
    }

    public void removeSong(String playlist, Object[] songData) {
        thisUser.getPlaylist(playlist).removeSong(songData);
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
