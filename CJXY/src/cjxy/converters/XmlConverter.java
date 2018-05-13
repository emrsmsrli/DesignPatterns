package cjxy.converters;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.*;

public class XmlConverter extends Converter {
    public class MapEntryConverter implements com.thoughtworks.xstream.converters.Converter {
        public boolean canConvert(Class clazz) {
            return AbstractMap.class.isAssignableFrom(clazz);
        }

        public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        }

        public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
            return xmlToMap(reader, new HashMap<>());
        }

        private Map<String, Object> xmlToMap(HierarchicalStreamReader reader, Map<String, Object> map) {
            List<Object> list = new ArrayList<>();
            while(reader.hasMoreChildren()) {
                reader.moveDown();
                if(reader.hasMoreChildren())
                    list.add(xmlToMap(reader, new HashMap<>()));
                else
                    map.put(reader.getNodeName(), reader.getValue());
                reader.moveUp();
            }

            if(list.isEmpty())
                return map;
            if(list.size() == 1)
                map.put(reader.getNodeName(), list.get(0));
            else
                map.put(reader.getNodeName(), list);
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
