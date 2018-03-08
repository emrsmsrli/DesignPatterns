package application.people.staff;

import application.people.Patient;
import application.people.staff.task.ITaskExecuter;
import application.people.staff.task.TaskResult;

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