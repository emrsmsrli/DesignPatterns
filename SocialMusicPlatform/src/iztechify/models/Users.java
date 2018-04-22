package iztechify.models;

import iztechify.models.music.Song;
import iztechify.models.music.Artist;
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

    public void befriend(String u1, String u2) {
        getUser(u1).addFriend(u2);
        getUser(u2).addFriend(u1);
        setChanged();
        notifyObservers();
    }

    public void addPlaylist(User user, String name) {
        user.addPlaylist(name);
        setChanged();
        notifyObservers();
    }

    public void addSongToPlaylist(Music music, User user, String playlist, Object[] data) {
        Song s = music.getArtist((String)data[2]).getAlbum((String)data[1]).getSong((String)data[0]);
        user.getPlaylist(playlist).addSong(s);
        setChanged();
        notifyObservers();
    }

    public List<Song> getTop3Songs() {
        List<Song> allSongs = new ArrayList<>();
        for (User user : users) {
            for(Playlist playlist : user.getPlaylists()) {
                allSongs.addAll(playlist.getSongs());
            }
        }

        if(allSongs.size() < 3)
            return new ArrayList<>();

        Map<Song, Integer> countMap = findFrequencies(allSongs);
        Song first = Collections.max(countMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        countMap.remove(first);
        Song second = Collections.max(countMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        countMap.remove(second);
        Song third = Collections.max(countMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        List<Song> top3 = new ArrayList<>();
        top3.add(first);
        top3.add(second);
        top3.add(third);
        return top3;
    }

    public List<Artist> getTop3Artists() {
        List<Artist> allArtist = new ArrayList<>();
        for (User user : users) {
            for(Playlist playlist : user.getPlaylists()) {
                for(Song song : playlist.getSongs()) {
                    allArtist.add(song.getAlbum().getArtist());
                }
            }
        }

        if(allArtist.size() < 3)
            return new ArrayList<>();

        Map<Artist, Integer> countMap = findFrequencies(allArtist);
        Artist first = Collections.max(countMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        countMap.remove(first);
        Artist second = Collections.max(countMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        countMap.remove(second);
        Artist third = Collections.max(countMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        List<Artist> top3 = new ArrayList<>();
        top3.add(first);
        top3.add(second);
        top3.add(third);
        return top3;
    }

    private <T> Map<T, Integer> findFrequencies(List<T> list) {
        Map<T, Integer> counterMap = new HashMap<>();
        for(T element: list){
            Integer frequency = counterMap.getOrDefault(element, 0);
            counterMap.put(element, frequency + 1);
        }
        return counterMap;
    }
}
