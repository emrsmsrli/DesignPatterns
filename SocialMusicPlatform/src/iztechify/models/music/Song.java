package iztechify.models.music;

import java.util.Observable;

public class Song extends Observable{
    private String title;
    private String length;

    public Song(String title, String length) {
        this.title = title;
        this.length = length;
    }

    public void setTitle(String newTitle){
        title = newTitle;
        setChanged();
        notifyObservers(this);
    }

    public void setLength(String length) {
        this.length = length;
        setChanged();
        notifyObservers(this);
    }

    public String getTitle() {
        return title;
    }

    public String getLength() {
        return length;
    }

}
