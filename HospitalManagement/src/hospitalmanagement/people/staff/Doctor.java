package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.people.Patient;
import hospitalmanagement.people.staff.task.Task;

public class Doctor extends HospitalStaff {
    public static final Task TASK_OPERATION = new Task();
    public static final Task TASK_VISIT = new Task();
    public static final Task TASK_DISMISS = new Task();

    public Doctor(IMediator mediator, String name) {
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
        return "@Doctor [name: " + name + "]";
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
                case "operation": TASK_OPERATION.setProbability(prob); break;
                case "visit": TASK_VISIT.setProbability(prob); break;
                case "dismiss": TASK_DISMISS.setProbability(prob); break;
                default: System.err.println("unknown task: " + taskAndProb[0] + ". skipping..");
            }
        }
    }
}
