package iztechify.controllers;

import iztechify.models.Users;
import iztechify.models.music.Playlist;
import iztechify.models.user.User;

import java.util.List;

public class UserController implements Controller {
    private Users allUsers;
    private User thisUser;

    public UserController(Users allUsers, User thisUser) {
        this.allUsers = allUsers;
        this.thisUser = thisUser;
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
        return thisUser.getFriend(username).getPlaylists();
    }

    public Playlist getFriendPlaylist(String username, String playlistName) {
        return thisUser.getFriend(username).getPlaylist(playlistName);
    }
}
