package cjxy.datatypes;

public class YamlFile extends AbstractDataFormat {
    public enum Extension {
        YAML,
        YML
    }

    private Extension extension;

    public YamlFile(String filePath, String content, Extension extension) {
        super(filePath, content);
        this.extension = extension;
    }

    @Override
    public IDataFormat toCsv() {
        return null;
    }

    @Override
    public IDataFormat toYaml(Extension extension) {
        if(this.extension == extension)
            return this;

        switch(extension) {
            case YAML:
                break;
            case YML:
                break;
        }

        // TODO remove this
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
