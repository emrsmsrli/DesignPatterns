package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

// TODO make other models observable as well
public class Album extends Observable {
    private String title;
    private String description;
    private List<Song> songs;

    protected Album(String title, String description) { // TODO add songs?
        this.title = title;
        this.description = description;
        this.songs = new ArrayList<>();
    }

    protected void addSongToAlbum(Song song){ // TODO save to json file
        songs.add(song);
    }

    protected boolean removeSong(Song song){ // TODO save to json file
        return songs.remove(song);
    }
}
