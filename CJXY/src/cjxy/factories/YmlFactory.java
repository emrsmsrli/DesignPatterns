package cjxy.factories;

import cjxy.datatypes.Yaml;

public class YmlFactory extends AbstractYamlFactory {
    YmlFactory() {
        super(Yaml.Extension.YML);
    }
}
