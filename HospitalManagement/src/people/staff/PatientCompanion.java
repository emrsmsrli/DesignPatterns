package people.staff;

import people.Patient;
import people.staff.task.TaskResult;

public class PatientCompanion extends HospitalStaff {
    private static float takeMriProbability = 0;
    private static float takeXRayProbability = 0;

    public PatientCompanion(String name) {
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
                case "mri": takeMriProbability = prob; break;
                case "xray": takeXRayProbability = prob; break;
                default: System.err.println("unknown people.staff.task: " + taskAndProb[0] + ". skipping..");
            }
        }
    }
}