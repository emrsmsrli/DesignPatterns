package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.people.staff.task.Task;
import hospitalmanagement.util.names.Name;

public class Nurse extends HospitalStaff {
    private static final Task[] tasks = {
            new Task("give medicine"),
            new Task("take blood"),
    };

    public Nurse(IMediator mediator, Name name) {
        super(mediator, name);
    }

    @Override
    public void executeTask(int taskId) {
        Task task = tasks[taskId - 4];
        Task.Result result = task.execute(this);
        reportToHospital(task, result);
    }

    @Override
    public String toString() {
        return "Nurse " + super.toString();
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
                case "medicine": tasks[0].setProbability(prob); break;
                case "take_blood": tasks[1].setProbability(prob); break;
                default: System.err.println("unknown task: " + taskAndProb[0] + ". skipping..");
            }
        }
    }
}
