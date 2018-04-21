package iztechify.models.user;

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

    public void addPlaylist(Playlist playlist){
        playlists.add(playlist);
        setChanged();
        notifyObservers();
    }

    public void addFriend(User user){
        friends.add(user);
        user.friends.add(this);
        setChanged();
        notifyObservers();
    }

    public String getUsername() {
        return username;
    }

    public List<Playlist> getPlaylists(){
        return playlists;
    }

    public Playlist getPlaylist(String name) {
        for(Playlist p : playlists)
            if(p.getName().equals(name))
                return p;
        return null;
    }

    public List<User> getFriends() {
        return friends;
    }

    public User getFriend(String otherUsername) {
        for(User u : friends)
            if(u.getUsername().equals(otherUsername))
                return u;
        return null;
    }
}