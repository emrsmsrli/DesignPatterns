package cjxy.factories;

import cjxy.datatypes.DataFormat;

interface IDataFormatFactory {
    DataFormat createDataFormat(String path, String contents);
}
