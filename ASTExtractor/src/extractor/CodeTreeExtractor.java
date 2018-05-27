package extractor;

import extractor.parser.ASTParser;
import extractor.project.JavaProject;

public class CodeTreeExtractor {
    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            System.err.println("Provide a folder path for .ast files");
            return;
        }

        JavaProject project = ASTParser.instance().generateProject(args[0]);
        project.printNameTree();
        System.out.println("Total num of classes: " + project.getClassCount());
        System.out.println("Total num of methods: " + project.getMethodCount());
        System.out.println("Total num of variables: " + project.getVariableCountInClasses());
        System.out.println("Total num of variables in methods: " + project.getVariableCountInMethods());
        System.out.println("Avg num of methods per class: " + project.getAvgNumberOfMethods());
        System.out.println("Avg num of variables per class: " + project.getAvgNumOfVariablesInClasses());
        System.out.println("Avg num of variables per method: " + project.getAvgNumOfVariablesInMethods());
    }
}
