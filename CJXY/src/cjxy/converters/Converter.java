package cjxy.converters;

import com.fasterxml.jackson.databind.ObjectMapper;

abstract class Converter implements IConverter {
    ObjectMapper mapper;

    String convert(IConverter reader, String content) {
        try {
            return write(reader.read(content));
        } catch(Exception e) {
            System.err.println(e.toString());
            return null;
        }
    }
}
