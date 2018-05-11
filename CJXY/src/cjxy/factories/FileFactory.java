package cjxy.factories;

import cjxy.datatypes.DataExchangeFile;
import cjxy.util.FileHelper;
import cjxy.datatypes.CsvFile;
import cjxy.datatypes.JsonFile;
import cjxy.datatypes.XmlFile;
import cjxy.datatypes.YamlFile;

public class FileFactory {

    public DataExchangeFile getFile(String filePath, String content) {
        if(filePath == null)
            return null;
        try {
            String extension = FileHelper.getExtension(filePath).toLowerCase();
            switch(extension) {
                case "csv":
                    return new CsvFile(filePath, content);
                case "json":
                    return new JsonFile(filePath, content);
                case "xml":
                    return new XmlFile(filePath, content);
                case "yaml":
                    return new YamlFile(filePath, content);
                default:
                    return null;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Error while getting file extension");
            return null;
        }
    }
}
