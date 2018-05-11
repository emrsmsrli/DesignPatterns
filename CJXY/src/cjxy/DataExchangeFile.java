package cjxy;

public abstract class DataExchangeFile {
    private String filePath;
    private String content;

    public DataExchangeFile(String filePath, String content) {
        this.filePath = filePath;
        this.content = content;
    }

    public abstract DataExchangeFile convertToCSV();

    public abstract DataExchangeFile convertToJSON();

    public abstract DataExchangeFile convertToXML();

    public abstract DataExchangeFile convertToYAML();

    private String read() {
        return FileHelper.readFile(filePath);
    }

    public void save() {
        FileHelper.saveFile(filePath, content);
    }
}
