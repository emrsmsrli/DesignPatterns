package hospitalmanagement;

import hospitalmanagement.people.Patient;
import hospitalmanagement.people.staff.Doctor;
import hospitalmanagement.people.staff.Nurse;
import hospitalmanagement.people.staff.PatientCompanion;

import java.util.*;

public class HospitalDispatchAndMonitorSystem implements IMediator {
    // used for randomization of task results
    public static final Random random = new Random(new Date().getTime());

    private final List<Patient> patients = new ArrayList<>();
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Nurse> nurses = new ArrayList<>();
    private final List<PatientCompanion> patientCompanions = new ArrayList<>();

    public HospitalDispatchAndMonitorSystem() {
        // TODO mantıklı bir şekilde ekle
        for(int i = 0; i < 5; ++i)
            patients.add(new Patient(this, "patient" + i));
        doctors.add(new Doctor(this, "doctor1"));
        nurses.add(new Nurse(this, "nurse1"));
        patientCompanions.add(new PatientCompanion(this, "patcom1"));
    }

    public void monitor() {

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

    @Override
    public String toString() {
        return "patients: " + patients.toString() + '\n' +
                "doctors: " + doctors.toString() + '\n' +
                "nurses: " + nurses.toString() + '\n' +
                "patComps: " + patientCompanions.toString() + '\n';
    }
}
