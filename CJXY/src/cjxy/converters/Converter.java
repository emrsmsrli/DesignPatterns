package cjxy.converters;

import cjxy.util.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

abstract class Converter implements IConverter {
    protected ObjectMapper mapper;

    String convert(IConverter reader, String content) {
        try {
            return write(reader.read(content));
        } catch(Exception e) {
            Logger.get().error(e.toString());
            return null;
        }
    }

    /*private Object read(String content, ObjectMapper reader) throws Exception {
        if(reader instanceof CsvMapper) {
            CsvSchema schema = CsvSchema.emptySchema().withHeader();
            return reader.readerFor(Map.class).with(schema).readValue(content);
        }
        return reader.readValue(content, Object.class);
    }

    private String write(Object content, ObjectMapper writer) throws Exception {
        if(writer instanceof CsvMapper) {
            CsvMapper mapper = (CsvMapper) writer;
            mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
            String b = mapper.writerFor(String[].class).writeValueAsString(content);
            b = "";

            CsvSchema schema = ((CsvMapper) writer).schemaFor(content.getClass()).withHeader();
            //CsvSchema schema = CsvSchema.builder().addArrayColumn("name").addColumn("surname").setUseHeader(true).build();
            String a =  writer.writer(schema).writeValueAsString(content);
            return a;
        }
        return writer.writerWithDefaultPrettyPrinter().writeValueAsString(content);
    }*/
}
