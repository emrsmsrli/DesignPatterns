import java.util.List;
import java.util.Random;

public class HospitalStaff implements Mediator {
    Random randomTask;
    private String name;

    HospitalStaff(String name){
        randomTask = new Random();
        this.name = name;
    }

    @Override
    public void monitorPatients(List<Patient> patientList) {

    }

    @Override
    public void monitorHospitalStaff(List<HospitalStaff> staffList) {

    }

    @Override
    public void goPatientsRoom() {

    }

    @Override
    public void assignTaskToStaff() {

    }

    public String getName() {
        return name;
    }
}
