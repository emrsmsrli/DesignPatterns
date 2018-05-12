package cjxy.converters;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter extends Converter {
    private static JsonConverter instance;

    private JsonConverter() {
        mapper = new ObjectMapper(new JsonFactory());
    }

    @Override
    public String fromJson(String content) {
        return content;
    }

    @Override
    public String fromXml(String content) {
        return convert(XmlConverter.get(), content);
    }

    @Override
    public String fromYaml(String content) {
        return convert(YamlConverter.get(), content);
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

    public static JsonConverter get() {
        if(instance == null)
            instance = new JsonConverter();
        return instance;
    }
}
