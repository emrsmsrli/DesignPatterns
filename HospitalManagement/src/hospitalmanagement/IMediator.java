package hospitalmanagement;

import hospitalmanagement.people.Patient;
import hospitalmanagement.people.staff.task.Task;

public interface IMediator {
    void distributeProbabilities(String[] taskProbPairs);
    void monitor();
    void report(Room room, Task task, Task.Result taskResult);
    void registerNewPatient();
    void dismissPatient(Patient p);
}
