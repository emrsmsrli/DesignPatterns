import java.util.ArrayList;

public class Mediator {
    private ArrayList<HospitalStaff> staffList;
    private ArrayList<Patient> patients;

    Mediator(){
        staffList = new ArrayList<>();
        patients = new ArrayList<>();
    }

    void monitorPatients(){
        for(Patient patient : patients){
            System.out.println(patient);
        }
    }

    void monitorHospitalStaff(){
        for(HospitalStaff staff : staffList){
            System.out.println(staff);
        }
    }

    void goPatientsRoom(){

    }

    void assignTaskToStaff(){

    }

    // Hospital staffs' access.
    public ArrayList<HospitalStaff> getStaffList() {
        return staffList;
    }

    public void setStaffList(ArrayList<HospitalStaff> staffList) {
        this.staffList = staffList;
    }

    public void addStaff(HospitalStaff staff){
        staffList.add(staff);
    }

    // Patients' access.
    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient){
        patients.add(patient);
    }
}
