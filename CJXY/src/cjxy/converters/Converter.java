package cjxy.converters;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

abstract class Converter implements IConverter {
    ObjectMapper xmlMapper = new ObjectMapper(new XmlFactory());
    ObjectMapper jsonMapper = new ObjectMapper(new JsonFactory());
    ObjectMapper csvMapper = new CsvMapper();
    ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    String convert(String content, ObjectMapper reader, ObjectMapper writer) {
        try {
            Object xml = reader.readValue(content, Object.class);
            return writer.writeValueAsString(xml);
        } catch(Exception e) {
            return null;
        }
    }
}
