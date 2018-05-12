package cjxy.factories;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.XmlFile;

public class XmlFactory implements IDataFormatFactory {
    XmlFactory() {}

    @Override
    public DataFormat createDataFormat(String path, String contents) {
        return new XmlFile(path, contents);
    }
}
