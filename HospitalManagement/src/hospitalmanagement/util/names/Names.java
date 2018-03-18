package hospitalmanagement.util.names;

import hospitalmanagement.util.Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Names {
    private static List<String> firstNames = new ArrayList<>();
    private static List<String> lastNames = new ArrayList<>();

    static {
        try(Scanner scanner = new Scanner(new File("names.txt"))) {
            while(scanner.hasNextLine()) {
                String[] names = scanner.nextLine().trim().split(" ");
                firstNames.add(names[0]);
                lastNames.add(names[1]);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Name random() {
        return new Name(firstNames.get(Random.i(firstNames.size())),
                lastNames.get(Random.i(lastNames.size())));
    }
}
