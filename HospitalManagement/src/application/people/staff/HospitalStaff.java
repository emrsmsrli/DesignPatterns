package application.people.staff;

import application.IMediator;
import application.people.Patient;
import application.people.staff.task.ITaskExecuter;
import application.people.staff.task.TaskResult;

public abstract class HospitalStaff implements ITaskExecuter {
    private String name;
    private IMediator mediator;

    public HospitalStaff(IMediator mediator, String name){
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract TaskResult executeTask(Patient patient);
}