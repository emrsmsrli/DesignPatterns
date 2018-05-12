package cjxy.datatypes;

public class XmlFile extends AbstractDataFormat {
    public XmlFile(String filePath, String content) {
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
        return null;
    }

    @Override
    public IDataFormat toXml() {
        return this;
    }
}
