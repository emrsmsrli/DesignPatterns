package application.people.staff.task;

import application.people.Patient;

public interface ITaskExecuter {
    TaskResult executeTask(Patient patient);
}
