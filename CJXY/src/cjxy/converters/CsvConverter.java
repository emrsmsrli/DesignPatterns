package cjxy.converters;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.util.Map;

public class CsvConverter extends Converter {
    private static CsvConverter instance;

    private CsvConverter() {
        mapper = new CsvMapper();
    }

    @Override
    public String fromCsv(String content) {
        return content;
    }

    @Override
    public String fromYaml(String content) {
        return convert(YamlConverter.get(), content);
    }

    @Override
    public String fromXml(String content) {
        return convert(XmlConverter.get(), content);
    }

    @Override
    public String fromJson(String content) {
        return convert(JsonConverter.get(), content);
    }

    public Object read(String data) throws Exception {
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        return mapper.readerFor(Map.class).with(schema).readValue(data);
    }

    public String write(Object data) throws Exception {
        // TODO
        return mapper.writeValueAsString(data);
    }

    public static CsvConverter get() {
        if(instance == null)
            instance = new CsvConverter();
        return instance;
    }
}
