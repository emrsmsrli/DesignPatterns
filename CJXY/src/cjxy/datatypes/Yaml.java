package cjxy.datatypes;

import cjxy.converters.CsvConverter;
import cjxy.converters.JsonConverter;
import cjxy.converters.XmlConverter;
import cjxy.converters.YamlConverter;

public class Yaml extends DataFormat {
    public enum Extension {
        YAML,
        YML
    }

    public Yaml(String content) {
        super(content);
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
