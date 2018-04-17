package iztechify.models.music;

public class Song {
    private String title;
    private String length;
    private int popularityLevel;

    public Song(String title, String length) {
        this.title = title;
        this.length = length;
        popularityLevel = 0;
    }

    public int getPopularityLevel(){
        return popularityLevel;
    }
}
