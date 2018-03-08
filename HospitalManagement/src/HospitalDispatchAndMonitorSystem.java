import people.staff.Doctor;
import people.staff.Nurse;
import people.staff.PatientCompanion;

import java.util.Arrays;

public class HospitalDispatchAndMonitorSystem implements IMediator {

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
