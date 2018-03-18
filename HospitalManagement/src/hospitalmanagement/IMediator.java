package hospitalmanagement;

import hospitalmanagement.people.Patient;
import hospitalmanagement.people.staff.HospitalStaff;
import hospitalmanagement.people.staff.task.Task;

public interface IMediator {
    void distributeProbabilities(String[] taskProbPairs);
    void monitor();
    void report(HospitalStaff staff, Patient patient, Task task, Task.Result taskResult);
    void registerNewPatient();
    void dismissPatient(Patient patient);
}
