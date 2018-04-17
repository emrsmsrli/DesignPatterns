package iztechify.models.music;

import java.util.ArrayList;
import java.util.List;

public class Artist {
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
}
