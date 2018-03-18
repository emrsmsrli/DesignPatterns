package hospitalmanagement;

import hospitalmanagement.people.Patient;
import hospitalmanagement.people.staff.HospitalStaff;

public class Room {
    private Patient patient;
    private HospitalStaff staff;
    private int roomNumber;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        patient = null;
        staff = null;
    }

    public boolean isEmpty() {
        return patient == null;
    }

    public void setStaff(HospitalStaff staff) {
        this.staff = staff;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HospitalStaff getStaff() {
        return staff;
    }

    public Patient getPatient() {
        return patient;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber;
    }
}
