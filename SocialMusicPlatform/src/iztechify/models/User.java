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

    public void createPlaylist(String name){
        playlists.add(new Playlist(name));
    }

    public void addFriend(User user){
        friends.add(user);
    }

    public boolean removeFriend(User user){
        return friends.remove(user);
    }

    public List<Playlist> getPlaylistOfFriend(User user){
        return friends.contains(user) ? user.getPlaylists(): null;
    }

    public List<Playlist> getPlaylists(){
        return playlists;
    }
}
