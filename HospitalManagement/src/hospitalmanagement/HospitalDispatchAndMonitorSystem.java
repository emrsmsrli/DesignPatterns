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

    private final List<Room> rooms = new ArrayList<>();

    private final Scanner scanner = new Scanner(System.in);

    public HospitalDispatchAndMonitorSystem() {
        for(int i = 0; i < 20; ++i)
            rooms.add(new Room(i + 1));

        for(int i = 0; i < 2/*10*/; ++i)
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
    public void dismissPatient(Patient p) {

    }

    @Override
    public void monitor() {
        PersonList<HospitalStaff> assignedStaff = new PersonList<>();

        patients.forEach(p -> {
            askForTask(p);

            int requestedTask = scanner.nextInt();

            HospitalStaff staff = null;
            switch(requestedTask) {
                case 1: case 2: case 3:
                    staff = doctors.first(d -> d.getCurrentRoom() == null); break;
                case 4: case 5:
                    staff = nurses.first(d -> d.getCurrentRoom() == null); break;
                case 6: case 7:
                    staff = patientCompanions.first(d -> d.getCurrentRoom() == null); break;
                default:
                    System.err.println("unknown task"); break;
            }
            if(staff == null)
                return; // continue

            staff.goToRoom(p.getCurrentRoom());
            staff.executeTask(requestedTask);
            assignedStaff.add(staff);
        });

        assignedStaff.forEach(HospitalStaff::getOutOfRoom);
    }

    @Override
    public void report(Room room, Task task, Task.Result taskResult) {
        System.out.println(room.getStaff().toString() + " executed task " +
                task.toString() + " on " + room.getPatient().toString() + " in " +
                room + " with " + taskResult.name());
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
