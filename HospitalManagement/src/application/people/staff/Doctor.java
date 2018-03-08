package application.people.staff;

import application.people.Patient;
import application.people.staff.task.TaskResult;

public class Doctor extends HospitalStaff {
    private static float operationProbability = 0;
    private static float visitProbability = 0;
    private static float dismissProbability = 0;

    public Doctor(String name) {
        super(name);
    }

    @Override
    public TaskResult executeTask(Patient patient) {
        return null;
    }

    public static void setProbabilities(String[] probs) {
        for(int i = 1; i < probs.length; ++i) {
            String[] taskAndProb = probs[i].split(":");
            float prob = 0;
            try {
                prob = Float.parseFloat(taskAndProb[1]);
            } catch(NumberFormatException e) {
                System.err.println("couldn't parse float: " + taskAndProb[1]);
                System.exit(-1);
            }
            switch(taskAndProb[0]) {
                case "operation": operationProbability = prob; break;
                case "visit": visitProbability = prob; break;
                case "dismiss": dismissProbability = prob; break;
                default: System.err.println("unknown application.people.staff.task: " + taskAndProb[0] + ". skipping..");
            }
        }
    }
}
