package cjxy.converters;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class YamlConverter extends Converter {
    private static YamlConverter instance;

    private YamlConverter() {
        mapper = new YAMLMapper();
    }

    @Override
    public String fromYaml(String content) {
        return content;
    }

    @Override
    public String fromXml(String content) {
        return convert(XmlConverter.get(), content);
    }

    @Override
    public String fromJson(String content) {
        return convert(JsonConverter.get(), content);
    }

    @Override
    public String fromCsv(String content) {
        return convert(CsvConverter.get(), content);
    }

    @Override
    public Object read(String data) throws Exception {
        return mapper.readValue(data, Object.class);
    }

    @Override
    public String write(Object data) throws Exception {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }

    public static YamlConverter get() {
        if(instance == null)
            instance = new YamlConverter();
        return instance;
    }
}
