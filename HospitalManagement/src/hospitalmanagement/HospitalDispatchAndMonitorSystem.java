package hospitalmanagement;

import hospitalmanagement.people.Patient;
import hospitalmanagement.people.staff.Doctor;
import hospitalmanagement.people.staff.HospitalStaff;
import hospitalmanagement.people.staff.Nurse;
import hospitalmanagement.people.staff.PatientCompanion;
import hospitalmanagement.people.staff.task.Task;
import hospitalmanagement.util.names.Names;
import hospitalmanagement.util.PersonList;

import java.util.*;

public class HospitalDispatchAndMonitorSystem implements IMediator {
    private final PersonList<Patient> patients = new PersonList<>();
    private final PersonList<Doctor> doctors = new PersonList<>();
    private final PersonList<Nurse> nurses = new PersonList<>();
    private final PersonList<PatientCompanion> patientCompanions = new PersonList<>();

    private final PersonList<Patient> toBeDismissedPatients = new PersonList<>();
    private final List<Room> rooms = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public HospitalDispatchAndMonitorSystem() {
        for(int i = 0; i < 20; ++i)
            rooms.add(new Room(i + 1));

        for(int i = 0; i < 10; ++i)
            registerNewPatient();

        for(int i = 0; i < 5; ++i) {
            doctors.add(new Doctor(this, Names.random()));
            nurses.add(new Nurse(this, Names.random()));
            patientCompanions.add(new PatientCompanion(this, Names.random()));
        }
    }

    @Override
    public void registerNewPatient() {
        Optional<Room> roomie = rooms.stream().filter(Room::isEmpty).findFirst();
        if(roomie.isPresent()) {
            Patient p = new Patient(this, Names.random());
            p.goToRoom(roomie.get());
            patients.add(p);
        }
    }

    @Override
    public void dismissPatient(Patient patient) {
        toBeDismissedPatients.add(patient);
    }

    @Override
    public void monitor() {
        PersonList<HospitalStaff> busyStaffs = new PersonList<>();

        patients.forEach(p -> {
            askForTask(p);

            HospitalStaff staff = null;
            int requestedTask;
            while(true) {
                requestedTask = scanner.nextInt();
                switch(requestedTask) {
                    case 1:
                    case 2:
                    case 3:
                        staff = doctors.first(d -> d.getCurrentRoom() == null);
                        break;
                    case 4:
                    case 5:
                        staff = nurses.first(d -> d.getCurrentRoom() == null);
                        break;
                    case 6:
                    case 7:
                        staff = patientCompanions.first(d -> d.getCurrentRoom() == null);
                        break;
                    default:
                        System.err.println("unknown task");
                        System.exit(-1);
                }
                if(staff != null)
                    break;

                System.err.println("no remaining staff for this task, choose another");
            }

            System.out.println("------- " + staff + " going to " + p.getCurrentRoom());
            staff.goToRoom(p.getCurrentRoom());
            staff.executeTask(requestedTask);
            busyStaffs.add(staff);
        });

        toBeDismissedPatients.forEach(patients::remove);
        toBeDismissedPatients.clear();
        busyStaffs.forEach(staff -> {
            System.out.println("------- " + staff + " getting out of " + staff.getCurrentRoom());
            staff.getOutOfRoom();
        });

        System.out.println("Total patient count: " + patients.size());
    }

    @Override
    public void report(HospitalStaff staff, Patient patient, Task task, Task.Result taskResult) {
        System.out.println(staff + " executed " + task + " on " + patient + " in " +
                staff.getCurrentRoom() + " with " + taskResult);
    }

    private void askForTask(Patient p) {
        System.out.println("Choose a task for patient: " + p.toString());
        System.out.println("1 - Perform operation");
        System.out.println("2 - Perform visit");
        System.out.println("3 - Dismiss from hospital");
        System.out.println("4 - Bring medicine to patient");
        System.out.println("5 - Take blood sample");
        System.out.println("6 - Take patient to MRI");
        System.out.println("7 - Take patient to X-Ray");
    }

    @Override
    public void distributeProbabilities(String[] taskProbData) {
        String[] taskProbs = Arrays.copyOfRange(taskProbData, 1, taskProbData.length);
        switch(taskProbData[0]) {
            case "doctor":
                Doctor.setProbabilities(taskProbs);
                break;
            case "nurse":
                Nurse.setProbabilities(taskProbs);
                break;
            case "patient_comp":
                PatientCompanion.setProbabilities(taskProbs);
                break;
            default:
                System.err.println("unknown class");
                System.exit(-1);
        }
    }

    @Override
    public String toString() {
        return "patients: " + patients + '\n' +
                "doctors: " + doctors + '\n' +
                "nurses: " + nurses + '\n' +
                "patComps: " + patientCompanions + '\n';
    }
}
