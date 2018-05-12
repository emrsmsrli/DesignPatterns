package cjxy.factories;

import cjxy.datatypes.*;

public class DataFormatFactory {
    private static DataFormatFactory instance;

    private IDataFormatFactory jsonFactory;
    private IDataFormatFactory xmlFactory;
    private IDataFormatFactory csvFactory;
    private IDataFormatFactory yamlFactory;
    private IDataFormatFactory ymlFactory;

    private DataFormatFactory() {
        jsonFactory = new JsonFactory();
        xmlFactory = new XmlFactory();
        csvFactory = new CsvFactory();
        yamlFactory = new YamlFactory();
        ymlFactory = new YmlFactory();
    }

    public DataFormat newJson(String path, String contents) {
        return jsonFactory.createDataFormat(path, contents);
    }

    public DataFormat newXml(String path, String contents) {
        return xmlFactory.createDataFormat(path, contents);
    }

    public DataFormat newCsv(String path, String contents) {
        return csvFactory.createDataFormat(path, contents);
    }

    public DataFormat newYaml(String path, String contents, YamlFile.Extension extension) {
        switch(extension) {
            case YAML:
                return yamlFactory.createDataFormat(path, contents);
            case YML:
                return ymlFactory.createDataFormat(path, contents);
        }
        return null;
    }

    public static DataFormatFactory get() {
        if(instance == null)
            instance = new DataFormatFactory();
        return instance;
    }
}
