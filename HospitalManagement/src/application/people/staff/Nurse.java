package application.people.staff;

import application.people.Patient;
import application.people.staff.task.TaskResult;

public class Nurse extends HospitalStaff {
    private static float medicineProbability = 0;
    private static float takeBloodProbability = 0;

    public Nurse(String name) {
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
                case "medicine": medicineProbability = prob; break;
                case "take_blood": takeBloodProbability = prob; break;
                default: System.err.println("unknown application.people.staff.task: " + taskAndProb[0] + ". skipping..");
            }
        }
    }
}
