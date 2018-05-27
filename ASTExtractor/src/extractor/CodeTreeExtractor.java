package extractor;

import extractor.parser.ASTParser;
import extractor.printers.JavaProjectPrinter;
import extractor.projects.JavaProject;

public class CodeTreeExtractor {
    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            System.err.println("Provide a folder path for .ast files");
            return;
        }

        JavaProject project = ASTParser.instance().generateProject(args[0]);

        /* How many classes exist.
           How many methods exist in each class.
           How many variables exist in each class.
           How many variables exist in each method.
           What is the average number of method per class.
           What is the average number of variables per class.
           What is the average number of variables per method. */
    }
}
