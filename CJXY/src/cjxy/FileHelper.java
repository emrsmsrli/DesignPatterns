package cjxy;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {
    private static FileHelper instance = null;

    private FileHelper() { }

    public static FileHelper getInstance() {
        if(instance == null)
            instance = new FileHelper();
        return instance;
    }

    public static String getExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        if(index <= 0)
            return null;
        return fileName.substring(index);
    }

    public static void saveFile(String fileName, String content) {
        try(Writer fileWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName), "utf-8"))) {
            fileWriter.write("something");
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Error while writing file. Filename: " + fileName);
        }
    }

    public static String readFile(String fileName) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(fileName));
            return new String(encoded, "utf-8");
        } catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Error while reading file. Filename: " + fileName);
            return null;
        }
    }
}
