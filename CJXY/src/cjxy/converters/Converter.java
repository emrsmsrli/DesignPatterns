package cjxy.converters;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

abstract class Converter implements IConverter {
    ObjectMapper xmlMapper = new XmlMapper();
    ObjectMapper jsonMapper = new ObjectMapper(new JsonFactory());
    ObjectMapper csvMapper = new CsvMapper();
    ObjectMapper yamlMapper = new YAMLMapper();

    String convert(String content, ObjectMapper reader, ObjectMapper writer) {
        try {
            Object xml = reader.readValue(content, Object.class);
            return writer.writeValueAsString(xml);
        } catch(Exception e) {
            return null;
        }
    }
}
