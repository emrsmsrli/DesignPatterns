package cjxy.datatypes;

import cjxy.converters.CsvConverter;
import cjxy.converters.JsonConverter;
import cjxy.converters.XmlConverter;
import cjxy.converters.YamlConverter;

public class YamlFile extends DataFormat {
    public enum Extension {
        YAML,
        YML
    }

    private Extension extension;

    public YamlFile(String filePath, String content, Extension extension) {
        super(filePath, content);
        this.extension = extension;
    }

    public Extension getExtension() {
        return extension;
    }

    @Override
    public String toCsv() {
        return CsvConverter.get().fromYaml(getContent());
    }

    @Override
    public String toYaml() {
        return YamlConverter.get().fromYaml(getContent());
    }

    @Override
    public String toJson() {
        return JsonConverter.get().fromYaml(getContent());
    }

    @Override
    public String toXml() {
        return XmlConverter.get().fromYaml(getContent());
    }
}
