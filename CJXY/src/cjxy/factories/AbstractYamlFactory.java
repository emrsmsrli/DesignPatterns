package cjxy.factories;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.YamlFile;

public abstract class AbstractYamlFactory implements IDataFormatFactory {
    private YamlFile.Extension extension;

    AbstractYamlFactory(YamlFile.Extension extension) {
        this.extension = extension;
    }

    @Override
    public DataFormat createDataFormat(String path, String contents) {
        return new YamlFile(path, contents, extension);
    }
}
