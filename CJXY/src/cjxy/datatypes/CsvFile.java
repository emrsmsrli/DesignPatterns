package cjxy.datatypes;

public class CsvFile extends AbstractDataFormat {
    public CsvFile(String filePath, String content) {
        super(filePath, content);
    }

    @Override
    public IDataFormat toCsv() {
        return this;
    }

    @Override
    public IDataFormat toYaml(YamlFile.Extension extension) {
        return null;
    }

    @Override
    public IDataFormat toJson() {
        return null;
    }

    @Override
    public IDataFormat toXml() {
        return null;
    }
}
