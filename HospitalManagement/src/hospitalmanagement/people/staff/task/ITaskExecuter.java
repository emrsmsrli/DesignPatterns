package hospitalmanagement.people.staff.task;

import hospitalmanagement.people.Patient;

public interface ITaskExecuter {
    Task.Result executeTask(Task task, Patient patient);
}
