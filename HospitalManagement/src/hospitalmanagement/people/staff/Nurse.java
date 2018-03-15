package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.people.staff.task.Task;

public class Nurse extends HospitalStaff {
    public static final Task TASK_MEDICINE = new Task();
    public static final Task TASK_TAKE_BLOOD = new Task();

    public Nurse(IMediator mediator) {
        super(mediator);
    }

    @Override
    public Task.Result executeTask(Task task) {
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
                case "medicine": TASK_MEDICINE.setProbability(prob); break;
                case "take_blood": TASK_TAKE_BLOOD.setProbability(prob); break;
                default: System.err.println("unknown task: " + taskAndProb[0] + ". skipping..");
            }
        }
    }
}
