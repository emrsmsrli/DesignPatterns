package cjxy.datatypes;

import cjxy.converters.CsvConverter;
import cjxy.converters.JsonConverter;
import cjxy.converters.XmlConverter;
import cjxy.converters.YamlConverter;

public class Json extends DataFormat {
    public Json(String content) {
        super(content);
    }

    @Override
    public String toCsv() {
        return CsvConverter.get().fromJson(getContent());
    }

    @Override
    public String toYaml() {
        return YamlConverter.get().fromJson(getContent());
    }

    @Override
    public String toJson() {
        return JsonConverter.get().fromJson(getContent());
    }

    @Override
    public String toXml() {
        return XmlConverter.get().fromJson(getContent());
    }
}
