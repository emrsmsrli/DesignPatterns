package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Playlist extends Observable implements Observer {
    private String name;
    private List<PlaylistEntry> entries;

    public Playlist(String name) {
        this.name = name;
        entries = new ArrayList<>();
    }

    public List<PlaylistEntry> getEntries() {
        return entries;
    }

    public List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        for(PlaylistEntry entry: entries){
            songs.add(entry.getSong());
        }
        return songs;
    }

//    public boolean addEntry(PlaylistEntry entry) {
//        boolean isSuccessful = entries.add(entry);
//        entry.addObserver(this);
//        setChanged();
//        notifyObservers(this);
//        return isSuccessful;
//    }
//
//    public boolean removeEntry(PlaylistEntry entry) {
//        boolean isSuccessful = entries.remove(entry);
//        setChanged();
//        notifyObservers(this);
//        entry.deleteObserver(this);
//        return isSuccessful;
//    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
