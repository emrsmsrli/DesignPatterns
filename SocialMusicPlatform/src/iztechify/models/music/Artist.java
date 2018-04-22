package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;
    private List<Album> albums;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAlbum(Album album) {
        this.albums.add(album);
    }

    public void removeAlbum(String name) {
        Album a = null;
        for(Album album : albums)
            if(album.getTitle().equals(name)) {
                a = album;
                break;
            }
        if(a != null)
            albums.remove(a);
    }

    public List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        for(Album album : albums)
            songs.addAll(album.getSongs());
        return songs;
    }

    public List<Song> getSongs(String album) {
        for(Album a : albums)
            if(a.getTitle().equals(album))
                return a.getSongs();
        return new ArrayList<>();
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
