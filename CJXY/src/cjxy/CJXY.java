package cjxy;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.YamlFile;
import cjxy.factories.DataFormatFactory;
import cjxy.util.IO;
import cjxy.util.Logger;

import java.nio.file.Paths;
import java.util.Scanner;

public class CJXY {
    public static void main(String[] args) {
        DataFormat file;
        DataFormatFactory factory = DataFormatFactory.get();
        String content, input, type, toType;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter file path: ");
            input = scanner.next();
            content = IO.get().readFile(input);
            System.out.println("Enter file type: ");
            type = scanner.next();
            System.out.println("Enter file type to convert: ");
            toType = scanner.next();

            switch (type.toLowerCase()) {
                case "csv": {
                    file = factory.newCsv(input, content);
                    break;
                }
                case "xml": {
                    file = factory.newXml(input, content);
                    break;
                }
                case "json": {
                    file = factory.newJson(input, content);
                    break;
                }
                case "yaml": {
                    file = factory.newYaml(input, content, YamlFile.Extension.YAML);
                    break;
                }
                case "yml": {
                    file = factory.newYaml(input, content, YamlFile.Extension.YML);
                    break;
                }
                default: continue;
            }

            switch (toType.toLowerCase()) {
                case "csv": {
                    content = file.toCsv();
                    break;
                }
                case "xml": {
                    content = file.toXml();
                    break;
                }
                case "json": {
                    content = file.toJson();
                    break;
                }
                case "yaml":
                case "yml": {
                    content = file.toYaml();
                    break;
                }
                default: continue;
            }
            try {
                input = Paths.get(input).toString().split("\\.")[0] + "." + toType;
                IO.get().writeFile(input ,content);
                Logger.get().info(type + " -> " + toType);
            } catch (Exception e) {
                Logger.get().error(type + " -> " + toType);
                e.printStackTrace();
            }
        }
    }
}
