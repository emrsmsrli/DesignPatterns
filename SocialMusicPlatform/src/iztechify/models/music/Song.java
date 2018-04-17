package iztechify.models.music;

public class Song {
    private String title;
    private String length;
    private int popularityLevel;

    protected Song(String title, String length) {
        this.title = title;
        this.length = length;
        popularityLevel = 0;
    }

    protected void setTitle(String newTitle){
        title = newTitle;
    }

    public int getPopularityLevel(){
        return popularityLevel;
    }
}
