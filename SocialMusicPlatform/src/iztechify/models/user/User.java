package iztechify.models.user;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<String> friends;
    private List<Playlist> playlists;

    public User(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void addFriend(String user) {
        friends.add(user);
    }

    public void setUsername(String newName){
        this.username = newName;
    }

    public String getUsername() {
        return username;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public Playlist getPlaylist(String name) {
        for (Playlist p : playlists)
            if (p.getName().equals(name))
                return p;
        return null;
    }

    public List<String> getFriends() {
        return friends;
    }
}
