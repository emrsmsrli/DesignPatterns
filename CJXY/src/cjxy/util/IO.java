package cjxy.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO {
    private static IO instance = null;

    private IO() {}

    public String readFile(String path) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            return new String(encoded, "utf-8");
        } catch(Exception e) {
            return null;
        }
    }

    public void writeFile(String fileName, String content) throws Exception {
        try(Writer fileWriter = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(fileName), "utf-8"))) {
            fileWriter.write(content);
            fileWriter.flush();
        }
    }

    public static IO get() {
        if(instance == null)
            instance = new IO();
        return instance;
    }
}
