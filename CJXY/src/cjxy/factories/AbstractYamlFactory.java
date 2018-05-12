package cjxy.factories;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.Yaml;

public abstract class AbstractYamlFactory implements IDataFormatFactory {

    AbstractYamlFactory() { }

    @Override
    public DataFormat createDataFormat(String contents) {
        return new Yaml(contents);
    }
}
