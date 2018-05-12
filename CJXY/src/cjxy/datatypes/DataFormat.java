package cjxy.datatypes;

public abstract class DataFormat {
    private String content;

    DataFormat(String content) {
        this.content = content;
    }

    public abstract String toCsv();
    public abstract String toYaml();
    public abstract String toJson();
    public abstract String toXml();

    public String getContent() {
        return content;
    }
}
