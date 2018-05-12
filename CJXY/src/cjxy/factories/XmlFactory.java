package cjxy.factories;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.Xml;

public class XmlFactory implements IDataFormatFactory {
    XmlFactory() {}

    @Override
    public DataFormat createDataFormat(String path, String contents) {
        return new Xml(path, contents);
    }
}
