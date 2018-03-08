import javax.net.ssl.HostnameVerifier;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Patient mert = new Patient("Mert");
        HospitalStaff staff = new Nurse(mediator, "MertS");

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
                mediator.monitorPatients();
                break;
            case 2:
                mediator.monitorHospitalStaff();
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
