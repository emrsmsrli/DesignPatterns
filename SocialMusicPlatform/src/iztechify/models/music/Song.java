package iztechify.models.music;

import java.util.Observable;

public class Song extends Observable {
    private String title;
    private String length;
    private int popularityLevel;

    public Song(String title, String length) {
        this.title = title;
        this.length = length;
        popularityLevel = 0;
    }

    public void setTitle(String newTitle){
        title = newTitle;
        notifyObservers();
    }

    public int getPopularityLevel(){
        return popularityLevel;
    }
}
