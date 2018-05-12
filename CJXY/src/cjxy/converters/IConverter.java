package cjxy.converters;

public interface IConverter {
    String fromJson(String content);
    String fromXml(String content);
    String fromYaml(String content);
    String fromCsv(String content);
}
