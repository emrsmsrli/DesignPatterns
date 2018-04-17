package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String name;
    private List<iztechify.models.music.Song> songs;

    public Playlist(String name){
        this.name = name;
        songs = new ArrayList<>();
    }

    public boolean addSongToPlaylist(iztechify.models.music.Song song){ // TODO save to json file
        return songs.add(song);
    }

    public boolean removeSongFromPlaylist(iztechify.models.music.Song song){ // TODO save to json file
        return songs.remove(song);
    }
}
