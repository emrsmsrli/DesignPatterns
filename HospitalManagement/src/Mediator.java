import java.util.List;

public interface Mediator {
    void monitorPatients(List<Patient> patientList);
    void monitorHospitalStaff(List<HospitalStaff> staffList);
    void goPatientsRoom();
    void assignTaskToStaff();
}
