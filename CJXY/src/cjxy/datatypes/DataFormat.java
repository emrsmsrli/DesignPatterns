package cjxy.datatypes;

public abstract class DataFormat {
    private String filePath;
    private String content;

    DataFormat(String filePath, String content) {
        this.filePath = filePath;
        this.content = content;
    }

    public abstract String toCsv();
    public abstract String toYaml();
    public abstract String toJson();
    public abstract String toXml();

    public String getFilePath() {
        return filePath;
    }

    public String getContent() {
        return content;
    }
}
