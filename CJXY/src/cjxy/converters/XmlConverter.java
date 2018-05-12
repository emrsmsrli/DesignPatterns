package cjxy.converters;

import com.fasterxml.jackson.databind.ObjectMapper;

public class XmlConverter extends Converter {
    private static XmlConverter instance;

    private XmlConverter() {}

    @Override
    public String fromXml(String content) {
        return content;
    }

    @Override
    public String fromJson(String content) {
        return convert(content, jsonMapper);
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
        return convert(content, reader, xmlMapper);
    }

    public static XmlConverter get() {
        if(instance == null)
            instance = new XmlConverter();
        return instance;
    }
}
