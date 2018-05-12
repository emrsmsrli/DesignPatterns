package cjxy.factories;

import cjxy.datatypes.YamlFile;

public class YmlFactory extends AbstractYamlFactory {
    YmlFactory() {
        super(YamlFile.Extension.YML);
    }
}
