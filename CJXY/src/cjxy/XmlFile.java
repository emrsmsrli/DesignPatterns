package cjxy;

import cjxy.IDataExchangeFile;

public class XmlFile implements IDataExchangeFile {

    private String filePath;
    private String content;

    @Override
    public IDataExchangeFile convertToCSV() {
        return null;
    }

    @Override
    public IDataExchangeFile convertToJSON() {
        return null;
    }

    @Override
    public IDataExchangeFile convertToXML() {
        return null;
    }

    @Override
    public IDataExchangeFile convertToYAML() {
        return null;
    }
}
