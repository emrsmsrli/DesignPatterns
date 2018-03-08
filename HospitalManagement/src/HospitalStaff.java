import java.util.Random;

public class HospitalStaff {
    Random randomTask;
    private Mediator mediator;
    private String name;

    HospitalStaff(Mediator m, String n){
        randomTask = new Random();
        name = n;
        mediator = m;
    }

    public String getName() {
        return name;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
