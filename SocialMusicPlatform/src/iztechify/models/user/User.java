package iztechify.models.user;

import iztechify.models.music.Playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class User extends Observable implements Observer {
    private String username;
    private List<User> friends;
    private List<Playlist> playlists;

    public User(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
        playlist.addObserver(this);
        setChanged();
        notifyObservers(this);
    }

    public void addFriend(User user) {
        friends.add(user); // if user A added user B as a friend
        user.friends.add(this); // user B should have user A as a friend too
        setChanged();
        notifyObservers(this);
    }

    public void setUsername(String newName){
        this.username = newName;
        setChanged();
        notifyObservers(this);
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

    public List<User> getFriends() {
        return friends;
    }

    public User getFriend(String otherUsername) {
        for (User u : friends)
            if (u.getUsername().equals(otherUsername))
                return u;
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg == null)
            return;
        if(arg instanceof Playlist){
            System.out.println("Playlist changed");     //todo do playlist change.
        }
    }
}
