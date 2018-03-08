package people.staff.task;

import people.Patient;

public interface ITaskExecuter {
    TaskResult executeTask(Patient patient);
}
