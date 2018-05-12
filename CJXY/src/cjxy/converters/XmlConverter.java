package cjxy.converters;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlConverter extends Converter {
    private static XmlConverter instance;

    private XmlConverter() {
        mapper = new XmlMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    }

    @Override
    public String fromXml(String content) {
        return content;
    }

    @Override
    public String fromJson(String content) {
        return convert(JsonConverter.get(), content);
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
        return mapper.readTree(data.getBytes());
    }

    @Override
    public String write(Object data) throws Exception {
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
    }

    public static XmlConverter get() {
        if(instance == null)
            instance = new XmlConverter();
        return instance;
    }
}
