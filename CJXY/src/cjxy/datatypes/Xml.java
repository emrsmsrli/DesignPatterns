package cjxy.datatypes;

import cjxy.converters.CsvConverter;
import cjxy.converters.JsonConverter;
import cjxy.converters.XmlConverter;
import cjxy.converters.YamlConverter;

public class Xml extends DataFormat {
    public Xml(String content) {
        super(content);
    }

    @Override
    public String toCsv() {
        return CsvConverter.get().fromXml(getContent());
    }

    @Override
    public String toYaml() {
        return YamlConverter.get().fromXml(getContent());
    }

    @Override
    public String toJson() {
        return JsonConverter.get().fromXml(getContent());
    }

    @Override
    public String toXml() {
        return XmlConverter.get().fromXml(getContent());
    }
}
