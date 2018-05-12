package cjxy.factories;

import cjxy.datatypes.Yaml;

public class YamlFactory extends AbstractYamlFactory {
    YamlFactory() {
        super(Yaml.Extension.YAML);
    }
}
