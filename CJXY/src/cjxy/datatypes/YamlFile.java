package cjxy.datatypes;

public class YamlFile extends AbstractDataFormat {
    public enum YamlExtensionType {
        YAML,
        YML
    }

    private YamlExtensionType type;

    public YamlFile(String filePath, String content, YamlExtensionType type) {
        super(filePath, content);
        this.type = type;
    }

    @Override
    public IDataFormat toCsv() {
        return null;
    }

    @Override
    public IDataFormat toYaml(YamlExtensionType type) {
        if(this.type == type)
            return this;

        switch(type) {
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
