package cjxy.factories;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.Json;

public class JsonFactory implements IDataFormatFactory {
    JsonFactory() {}

    @Override
    public DataFormat createDataFormat(String path, String contents) {
        return new Json(path, contents);
    }
}
