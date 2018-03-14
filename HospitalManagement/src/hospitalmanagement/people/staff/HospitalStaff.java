package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.people.Patient;
import hospitalmanagement.people.Person;
import hospitalmanagement.people.staff.task.ITaskExecuter;
import hospitalmanagement.people.staff.task.Task;

public abstract class HospitalStaff extends Person implements ITaskExecuter {
    public HospitalStaff(IMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public abstract Task.Result executeTask(Task task, Patient patient);
}