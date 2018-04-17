package iztechify.models.music;

import java.util.Observable;

public class Song extends Observable {
    private String title;
    private String length;

    public Song(String title, String length) {
        this.title = title;
        this.length = length;
    }

    public void setTitle(String newTitle){
        title = newTitle;
        notifyObservers();
    }
}
