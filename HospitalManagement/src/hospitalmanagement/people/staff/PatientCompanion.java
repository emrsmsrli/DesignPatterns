package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.people.Patient;
import hospitalmanagement.people.staff.task.Task;

public class PatientCompanion extends HospitalStaff {
    public static final Task TASK_TAKE_TO_MRI = new Task();
    public static final Task TASK_TAKE_TO_XRAY = new Task();

    public PatientCompanion(IMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public Task.Result executeTask(Task task, Patient patient) {
        return null;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public String toString() {
        return "@PatientCompanion [name: " + name + "]";
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
                case "mri": TASK_TAKE_TO_MRI.setProbability(prob); break;
                case "xray": TASK_TAKE_TO_XRAY.setProbability(prob); break;
                default: System.err.println("unknown task: " + taskAndProb[0] + ". skipping..");
            }
        }
    }
}
