package cjxy.datatypes;

public class JsonFile extends AbstractDataFormat {
    public JsonFile(String filePath, String content) {
        super(filePath, content);
    }

    @Override
    public IDataFormat toCsv() {
        return null;
    }

    @Override
    public IDataFormat toYaml(YamlFile.Extension extension) {
        return null;
    }

    @Override
    public IDataFormat toJson() {
        return this;
    }

    @Override
    public IDataFormat toXml() {
        return null;
    }
}
