package cjxy;

import cjxy.datatypes.DataFormat;
import cjxy.datatypes.Yaml;
import cjxy.factories.DataFormatFactory;
import cjxy.util.IO;
import cjxy.util.Logger;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class CJXY {
    private static DataFormatFactory factory = DataFormatFactory.get();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content;

        while(true) {
            System.out.println("Enter file path: ");
            String path = scanner.next();

            if(path.equals("quit"))
                break;

            File f = new File(path);
            if(!f.exists() && f.isDirectory()) {
                Logger.get().error(f.getPath() + " does not exists or a directory");
                continue;
            }

            content = IO.get().readFile(f.getPath());

            String[] tokens = f.getName().split("\\.");
            String fileNameWithoutExtension = String.join(".", Arrays.copyOfRange(tokens, 0, tokens.length - 1));
            String typeFrom = tokens[tokens.length - 1];

            DataFormat file = createDataFormat(typeFrom, content);
            if(file == null) {
                Logger.get().error("wrong type to convert from: " + typeFrom + " for " + f.getName());
                continue;
            }

            System.out.println("Enter file type to convert: ");
            String typeTo = scanner.next();

            switch(typeTo.toLowerCase()) {
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
                path = f.getParent() + File.separator + fileNameWithoutExtension + "." + typeTo;
                IO.get().writeFile(path, content);
                Logger.get().info(typeFrom + " -> " + typeTo);
            } catch(Exception e) {
                Logger.get().error(typeFrom + " -> " + typeTo + ". reason: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static DataFormat createDataFormat(String typeFrom, String content) {
        switch(typeFrom.toLowerCase()) {
            case "csv":
                return factory.newCsv(content);
            case "xml":
                return factory.newXml(content);
            case "json":
                return factory.newJson(content);
            case "yaml":
                return factory.newYaml(content, Yaml.Extension.YAML);
            case "yml":
                return factory.newYaml(content, Yaml.Extension.YML);
            default:
                return null;
        }
    }
}
