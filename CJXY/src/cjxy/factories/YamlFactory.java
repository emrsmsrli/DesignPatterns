package cjxy.factories;

import cjxy.datatypes.YamlFile;

public class YamlFactory extends AbstractYamlFactory {
    YamlFactory() {
        super(YamlFile.Extension.YAML);
    }
}
