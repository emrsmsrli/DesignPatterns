package cjxy.datatypes;

public interface IDataFormat {
    IDataFormat toCsv();
    IDataFormat toYaml(YamlFile.YamlExtensionType type);
    IDataFormat toJson();
    IDataFormat toXml();
}
