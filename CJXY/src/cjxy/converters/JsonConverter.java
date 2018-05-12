package cjxy.converters;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter extends Converter {
    private static JsonConverter instance;

    private JsonConverter() {}

    @Override
    public String fromJson(String content) {
        return content;
    }

    @Override
    public String fromXml(String content) {
        return convert(content, xmlMapper);
    }

    @Override
    public String fromYaml(String content) {
        return convert(content, yamlMapper);
    }

    @Override
    public String fromCsv(String content) {
        return convert(content, csvMapper);
    }

    private String convert(String content, ObjectMapper reader) {
        return convert(content, reader, jsonMapper);
    }

    public static JsonConverter get() {
        if(instance == null)
            instance = new JsonConverter();
        return instance;
    }
}
