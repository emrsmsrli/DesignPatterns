package cjxy.converters;

import com.fasterxml.jackson.databind.ObjectMapper;

public class YamlConverter extends Converter {
    private static YamlConverter instance;

    private YamlConverter() {}

    @Override
    public String fromYaml(String content) {
        return content;
    }

    @Override
    public String fromXml(String content) {
        return convert(content, xmlMapper);
    }

    @Override
    public String fromJson(String content) {
        return convert(content, jsonMapper);
    }

    @Override
    public String fromCsv(String content) {
        return convert(content, csvMapper);
    }

    private String convert(String content, ObjectMapper reader) {
        return convert(content, reader, yamlMapper);
    }

    public static YamlConverter get() {
        if(instance == null)
            instance = new YamlConverter();
        return instance;
    }
}
