package application;

import application.people.Patient;
import application.people.staff.Doctor;
import application.people.staff.Nurse;
import application.people.staff.PatientCompanion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HospitalDispatchAndMonitorSystem implements IMediator {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Nurse> nurses = new ArrayList<>();
    private List<PatientCompanion> patientCompanions = new ArrayList<>();

    public HospitalDispatchAndMonitorSystem() {

    }

    @Override
    public void distributeProbabilities(String[] taskProbData) {
        switch(taskProbData[0]) {
            case "doctor":
                Doctor.setProbabilities(Arrays.copyOfRange(taskProbData, 1, taskProbData.length));
                break;
            case "nurse":
                Nurse.setProbabilities(Arrays.copyOfRange(taskProbData, 1, taskProbData.length));
                break;
            case "patient_comp":
                PatientCompanion.setProbabilities(Arrays.copyOfRange(taskProbData, 1, taskProbData.length));
                break;
        }
    }
}
