package cjxy.datatypes;

import cjxy.converters.CsvConverter;
import cjxy.converters.JsonConverter;
import cjxy.converters.XmlConverter;
import cjxy.converters.YamlConverter;

public class CsvFile extends DataFormat {
    public CsvFile(String filePath, String content) {
        super(filePath, content);
    }

    @Override
    public String toCsv() {
        return CsvConverter.get().fromCsv(getContent());
    }

    @Override
    public String toYaml() {
        return YamlConverter.get().fromCsv(getContent());
    }

    @Override
    public String toJson() {
        return JsonConverter.get().fromCsv(getContent());
    }

    @Override
    public String toXml() {
        return XmlConverter.get().fromCsv(getContent());
    }
}
