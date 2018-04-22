package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Album extends Observable implements Observer{
    private String title;
    private String description;

    private List<Song> songs;

    public Album(String title, String description) {
        this.title = title;
        this.description = description;
        this.songs = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void remove(Song song){
        songs.remove(song);
    }

    @Override
    public void update(Observable o, Object arg) {
        //todo: add song to songs list here
    }
}
