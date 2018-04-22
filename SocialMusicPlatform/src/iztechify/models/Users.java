package iztechify.models;

import iztechify.models.user.Playlist;
import iztechify.models.user.User;

import java.util.*;

public class Users extends Observable {
    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String username) {
        for(User u : users)
            if(u.getUsername().equals(username))
                return u;
        return null;
    }

    public void addUser(String username) {
        users.add(new User(username));
        setChanged();
        notifyObservers();
    }

    public void befriend(User u1, User u2) {
        u1.addFriend(u2);
        u2.addFriend(u1);
        setChanged();
        notifyObservers();
    }

    public void addPlaylist(User user, String name) {
        user.addPlaylist(new Playlist(name));
        setChanged();
        notifyObservers();
    }

   /* fixme public List<Song> getAllSongsInPlaylists() {
        List<Playlist> allPlaylists = new ArrayList<Playlist>();
        List<Song> allSongs = new ArrayList<Song>();
        for(User user: users){
            allPlaylists.addAll(user.getPlaylists());
        }
        for(Playlist playlist: allPlaylists){
            allSongs.addAll(playlist.getSongs());
        }
        return allSongs;
    }

    private <T> Map<T, Integer> findFrequencies(List<T> list){
        Map<T, Integer> counterMap = new HashMap<>();
        for(T element: list){
            Integer frequency = counterMap.getOrDefault(element, 0);
            counterMap.put(element, frequency + 1);
        }
        return counterMap;
    }*/
}
