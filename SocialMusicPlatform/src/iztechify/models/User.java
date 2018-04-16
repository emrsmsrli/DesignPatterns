package iztechify.models;

import iztechify.models.music.Playlist;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<User> friends;
    private List<Playlist> playlists;

    public User(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }
}
