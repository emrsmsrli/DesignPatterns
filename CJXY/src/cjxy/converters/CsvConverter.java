package cjxy.converters;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @Override
    public Object read(String data) throws Exception {
        CsvSchema schema = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<String, String>> it = mapper.readerFor(Map.class).with(schema).readValues(data);
        List<Map<String, String>> list = new ArrayList<>();
        while(it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    @Override
    public String write(Object data) throws Exception {
        if(data instanceof List) {
            Object first = ((List) data).get(0);
            if(!(first instanceof Map))
                return mapper.writeValueAsString(data);
            return write(first, data);
        } else if(data instanceof Map) {
            return write(data, data);
        } else
            return mapper.writeValueAsString(data);
    }

    private String write(Object hdrs, Object data) throws Exception {
        Set headers = ((Map) hdrs).keySet();
        CsvSchema.Builder schemaBuilder = CsvSchema.builder();
        schemaBuilder.setUseHeader(true);
        for(Object header : headers) {
            schemaBuilder.addColumn((String) header);
        }
        CsvSchema schema = schemaBuilder.build();
        return mapper.writer().with(schema).writeValueAsString(data);
    }

    public static CsvConverter get() {
        if(instance == null)
            instance = new CsvConverter();
        return instance;
    }
}
