package hospitalmanagement.people.staff.task;

import hospitalmanagement.people.Patient;

public interface ITaskExecuter {
    TaskResult executeTask(Patient patient);
}
