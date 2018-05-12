package cjxy;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.Yaml;
import cjxy.factories.DataFormatFactory;
import cjxy.util.IO;
import cjxy.util.Logger;

import java.nio.file.Paths;
import java.util.Scanner;

public class CJXY {
    private static DataFormatFactory factory = DataFormatFactory.get();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content;

        while(true){
            System.out.println("Enter file path: ");
            String path = scanner.next();

            if(path.equals("quit"))
                break;
            content = IO.get().readFile(path);

            System.out.println("Enter file type: ");
            String typeFrom = scanner.next();

            System.out.println("Enter file type to convert: ");
            String typeTo = scanner.next();

            DataFormat file = createDataFormat(typeFrom, path, content);
            if(file == null) {
                Logger.get().error("wrong type to convert from: " + typeFrom + " for " + path);
                continue;
            }

            switch (typeTo.toLowerCase()) {
                case "csv":
                    content = file.toCsv();
                    break;
                case "xml":
                    content = file.toXml();
                    break;
                case "json":
                    content = file.toJson();
                    break;
                case "yaml":
                case "yml":
                    content = file.toYaml();
                    break;
                default:
                    Logger.get().error("wrong type to convert to: " + typeTo + " for " + path);
                    continue;
            }

            if(content == null) {
                Logger.get().error("could not convert from " + typeFrom + " to " + typeTo);
                continue;
            }

            try {
                path = Paths.get(path).toString().split("\\.")[0] + "." + typeTo;
                IO.get().writeFile(path ,content);
                Logger.get().info(typeFrom + " -> " + typeTo);
            } catch (Exception e) {
                Logger.get().error(typeFrom + " -> " + typeTo);
                e.printStackTrace();
            }
        }
    }

    private static DataFormat createDataFormat(String typeFrom, String path, String content) {
        switch (typeFrom.toLowerCase()) {
            case "csv":
                return factory.newCsv(path, content);
            case "xml":
                return factory.newXml(path, content);
            case "json":
                return factory.newJson(path, content);
            case "yaml":
                return factory.newYaml(path, content, Yaml.Extension.YAML);
            case "yml":
                return factory.newYaml(path, content, Yaml.Extension.YML);
            default:
                return null;
        }
    }
}
