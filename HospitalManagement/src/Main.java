import hospitalmanagement.HospitalDispatchAndMonitorSystem;
import hospitalmanagement.IMediator;
import hospitalmanagement.util.Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.err.println("provide a probability distribution file");
            System.exit(-1);
        }

        IMediator mediator = new HospitalDispatchAndMonitorSystem();
        distributeProbabilities(mediator, args[0]);

        for(int i = 0; i < Integer.MAX_VALUE; ++i) {
            if(Random.f() < .1)
                mediator.registerNewPatient();
            mediator.monitor();
        }
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
                if(!s.hasNext())
                    throw new RuntimeException("no new line");
                String[] taskProbabilityPairs = s.nextLine().split(",");
                mediator.distributeProbabilities(taskProbabilityPairs);
            }
        } catch(FileNotFoundException e) {
            System.err.println("probability distribution file not found");
            System.exit(-1);
        } catch(RuntimeException e) {
            e.printStackTrace();
        }
    }
}
