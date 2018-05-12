package cjxy.factories;

import cjxy.datatypes.Csv;
import cjxy.datatypes.DataFormat;

public class CsvFactory implements IDataFormatFactory {
    CsvFactory() {}

    @Override
    public DataFormat createDataFormat(String path, String contents) {
        return new Csv(path, contents);
    }
}
