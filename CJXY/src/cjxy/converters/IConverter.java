package cjxy.converters;

public interface IConverter {
    String fromJson(String content);
    String fromXml(String content);
    String fromYaml(String content);
    String fromCsv(String content);

    Object read(String data) throws Exception;  // read from one data type to intermediate
    String write(Object data) throws Exception; // write to other data type from intermediate
}
