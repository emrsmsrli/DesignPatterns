package hospitalmanagement.people.staff.task;

import hospitalmanagement.people.staff.HospitalStaff;
import hospitalmanagement.util.Random;

public class Task {
    public enum Result {
        SUCCESS,
        FAILURE
    }

    public interface TaskAction {
        void execute(HospitalStaff staff);
    }

    private float probability = 0;
    private TaskAction action = null;
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public Task(String name, TaskAction action) {
        this(name);
        this.action = action;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public Result execute(HospitalStaff staff) {
        if(action != null)
            action.execute(staff);
        return Random.f() < probability ? Result.SUCCESS : Result.FAILURE;
    }

    @Override
    public String toString() {
        return name;
    }
}
