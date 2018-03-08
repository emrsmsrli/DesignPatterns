package people.staff;

import people.Patient;
import people.staff.task.ITaskExecuter;
import people.staff.task.TaskResult;

public abstract class HospitalStaff implements ITaskExecuter {
    private String name;

    public HospitalStaff(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract TaskResult executeTask(Patient patient);
}