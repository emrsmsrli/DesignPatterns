package iztechify.models;

import iztechify.models.music.Playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class User extends Observable{
    private String username;
    private List<User> friends;
    private List<Playlist> playlists;

    public User(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public boolean createPlaylist(String name){
        boolean isSuccessful = playlists.add(new Playlist(name));
        notifyObservers();
        return isSuccessful;
    }

    public boolean addFriend(User user){
        boolean isSuccessful = friends.add(user);
        notifyObservers();
        return isSuccessful;
    }

    public boolean removeFriend(User user){
        boolean isSuccessful = friends.remove(user);
        notifyObservers();
        return isSuccessful;
    }

    public List<Playlist> getPlaylists(){
        return playlists;
    }
}
