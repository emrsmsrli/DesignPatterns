package cjxy.converters;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CsvConverter extends Converter {
    private static CsvConverter instance;

    private CsvConverter() {}

    @Override
    public String fromCsv(String content) {
        return content;
    }

    @Override
    public String fromYaml(String content) {
        return convert(content, yamlMapper);
    }

    @Override
    public String fromXml(String content) {
        return convert(content, xmlMapper);
    }

    @Override
    public String fromJson(String content) {
        return convert(content, jsonMapper);
    }

    private String convert(String content, ObjectMapper reader) {
        return convert(content, reader, csvMapper);
    }

    public static CsvConverter get() {
        if(instance == null)
            instance = new CsvConverter();
        return instance;
    }
}
