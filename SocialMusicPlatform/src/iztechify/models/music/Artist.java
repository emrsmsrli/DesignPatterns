package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Artist extends Observable {
    private String name;
    private List<Album> albums;
    private int popularityLevel;

    public Artist(String name) {
        this.name = name;
        this.albums = new ArrayList<>();
        popularityLevel = 0;
    }

    private int getPopularityLevel(){
        return popularityLevel;
    }

    public int incrementPopularityLevel(){
        return ++popularityLevel;
    }

    public int decrementPopularityLevel(){
        return --popularityLevel;
    }
}
