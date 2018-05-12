package cjxy.datatypes;

public abstract class AbstractDataFormat implements IDataFormat {
    private String filePath;
    private String content;

    AbstractDataFormat(String filePath, String content) {
        this.filePath = filePath;
        this.content = content;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getContent() {
        return content;
    }
}
