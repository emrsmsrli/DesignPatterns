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

    public DataFormat newJson(String contents) {
        return jsonFactory.createDataFormat(contents);
    }

    public DataFormat newXml(String contents) {
        return xmlFactory.createDataFormat(contents);
    }

    public DataFormat newCsv(String contents) {
        return csvFactory.createDataFormat(contents);
    }

    public DataFormat newYaml(String contents, Yaml.Extension extension) {
        switch(extension) {
            case YAML:
                return yamlFactory.createDataFormat(contents);
            case YML:
                return ymlFactory.createDataFormat(contents);
        }
        return null;
    }

    public static DataFormatFactory get() {
        if(instance == null)
            instance = new DataFormatFactory();
        return instance;
    }
}
