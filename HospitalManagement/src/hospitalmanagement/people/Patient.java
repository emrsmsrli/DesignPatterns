package hospitalmanagement.people;

import hospitalmanagement.IMediator;

public class Patient extends Person {
    private String illness;

    public Patient(IMediator mediator, String name){
        super(mediator, name);
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public String toString() {
        return "@Patient [name: " + name + "]";
    }
}
