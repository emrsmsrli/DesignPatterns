package cjxy.factories;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.Yaml;

public abstract class AbstractYamlFactory implements IDataFormatFactory {
    private Yaml.Extension extension;

    AbstractYamlFactory(Yaml.Extension extension) {
        this.extension = extension;
    }

    @Override
    public DataFormat createDataFormat(String path, String contents) {
        return new Yaml(path, contents, extension);
    }
}
