import hospitalmanagement.HospitalDispatchAndMonitorSystem;
import hospitalmanagement.IMediator;
import hospitalmanagement.util.Random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IMediator mediator = new HospitalDispatchAndMonitorSystem();
        distributeProbabilities(mediator);

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
     */
    private static void distributeProbabilities(IMediator mediator) {
        try(Scanner s = new Scanner(new File("prob.txt"))) {
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
