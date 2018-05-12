package cjxy.factories;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.Xml;

public class XmlFactory implements IDataFormatFactory {
    XmlFactory() {}

    @Override
    public DataFormat createDataFormat(String contents) {
        return new Xml(contents);
    }
}
