package cjxy;

public class CsvFile extends DataExchangeFile {
    public CsvFile(String filePath, String content) {
        super(filePath, content);
    }

    @Override
    public DataExchangeFile convertToCSV() {
        return null;
    }

    @Override
    public DataExchangeFile convertToJSON() {
        return null;
    }

    @Override
    public DataExchangeFile convertToXML() {
        return null;
    }

    @Override
    public DataExchangeFile convertToYAML() {
        return null;
    }
}
