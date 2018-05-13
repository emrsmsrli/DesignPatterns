package cjxy.converters;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class XmlConverter extends Converter {
    public static class MapEntryConverter implements com.thoughtworks.xstream.converters.Converter {
        public boolean canConvert(Class clazz) {
            return AbstractMap.class.isAssignableFrom(clazz);
        }
        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) { }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            Map<String, Object> map = new HashMap<>();
            while(reader.hasMoreChildren()) {
                reader.moveDown();
                String key = reader.getNodeName(); // nodeName aka element's name
                Object value = reader.getValue();
                map.put(key, value);
                reader.moveUp();
            }
            return map;
        }
    }

    private static XmlConverter instance;
    private XStream xStream;

    private XmlConverter() {
        mapper = new XmlMapper();
        xStream = new XStream();
        xStream.alias("root", Map.class);
        xStream.registerConverter(new MapEntryConverter());
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
    public Object read(String data) {
        return xStream.fromXML(data);
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
