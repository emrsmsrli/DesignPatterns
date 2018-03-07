import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient("Mert"));
        patientList.add(new Patient("Emre"));
        patientList.add(new Patient("Sadık"));
        patientList.add(new Patient("Bahadır"));

        List<HospitalStaff> staffList = new ArrayList<>();
        staffList.add(new Nurse("MertS"));
        staffList.add(new PatientCompanion("SadıkS"));
        staffList.add(new Doctor("BahadırS"));

        Scanner scanner = new Scanner(System.in);
        int task;
        
        System.out.println("Choose a task:");
        System.out.println("1- Monitor patients");
        System.out.println("2- Monitor Hospital Staff");
        System.out.println("3- Perform operation");
        System.out.println("4- Perform visit");
        System.out.println("5- Dismiss from hospital");
        System.out.println("6- Bring medicine to patient");
        System.out.println("7- Take blood sample");
        System.out.println("8- Take patient to MRI");
        System.out.println("9- Take patient to X-Ray");

        task = scanner.nextInt();

        switch (task){
            case 1:
                staffList.get(0).monitorPatients(patientList);
                break;
            case 2:
                staffList.get(0).monitorHospitalStaff(staffList);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            default: break;
        }
    }
}
