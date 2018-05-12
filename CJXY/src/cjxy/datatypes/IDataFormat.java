package cjxy.datatypes;

public interface IDataFormat {
    IDataFormat toCsv();
    IDataFormat toYaml(YamlFile.Extension extension);
    IDataFormat toJson();
    IDataFormat toXml();
}
