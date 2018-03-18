package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.people.Patient;
import hospitalmanagement.people.staff.task.Task;
import hospitalmanagement.util.names.Name;

public class PatientCompanion extends HospitalStaff {
    private static final Task[] tasks = {
            new Task("take to mri"),
            new Task("take to xray"),
    };

    public PatientCompanion(IMediator mediator, Name name) {
        super(mediator, name);
    }

    @Override
    public void executeTask(int taskId) {
        Task task = tasks[taskId - 6];
        Patient p = getCurrentRoom().getPatient();
        Task.Result result = task.execute(this);
        reportToHospital(p, task, result);
    }

    @Override
    public String toString() {
        return "Companion " + super.toString();
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
                case "mri": tasks[0].setProbability(prob); break;
                case "xray": tasks[1].setProbability(prob); break;
                default: System.err.println("unknown task: " + taskAndProb[0] + ". skipping..");
            }
        }
    }
}
