import hospitalmanagement.HospitalDispatchAndMonitorSystem;
import hospitalmanagement.IMediator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("provide a probability distribution file");
            System.exit(0);
        }

        IMediator mediator = new HospitalDispatchAndMonitorSystem();
        distributeProbabilities(mediator, args[0]);

        System.out.println("Choose a .task:");
        System.out.println("1- Monitor patients");
        System.out.println("2- Monitor Hospital Staff");
        System.out.println("3- Perform operation");
        System.out.println("4- Perform visit");
        System.out.println("5- Dismiss from hospital");
        System.out.println("6- Bring medicine to patient");
        System.out.println("7- Take blood sample");
        System.out.println("8- Take patient to MRI");
        System.out.println("9- Take patient to X-Ray");
    }

    /**
     * Distribution file should be formatted as:
     *      <i>className</i>,<i>action:prob</i>,<i>action:prob</i>,... <br>
     *      <i>i.e</i> doctor,operation:0.3,visit:0.8,dismiss:0.3 <br><br>
     *
     *       Available classNames are {@code doctor}, {@code nurse} and {@code patient_comp}<br><br>
     *
     *      data is split with commas and action-probability pairs with colons
     * @param path distribution file path to read
     */
    private static void distributeProbabilities(IMediator mediator, String path) {
        try(Scanner s = new Scanner(new File(path))) {
            for(int i = 0; i < 3; ++i) {    // have 3 staff types
                String[] taskProbabilityPairs = s.nextLine().split(",");
                mediator.distributeProbabilities(taskProbabilityPairs);
            }
        } catch(FileNotFoundException e) {
            System.err.println("probability distribution file not found");
            System.exit(-1);
        }
    }
}
