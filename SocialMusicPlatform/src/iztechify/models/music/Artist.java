package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Artist extends Observable {
    private String name;
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        for (Album album : albums) {
            songs.addAll(album.getSongs());
        }
        return songs;
    }
}
