package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.people.Patient;
import hospitalmanagement.people.staff.task.ITaskExecuter;
import hospitalmanagement.people.staff.task.TaskResult;

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