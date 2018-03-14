package hospitalmanagement.people;

import hospitalmanagement.IMediator;

public abstract class Person {
    protected String name;
    protected IMediator mediator;

    public Person(IMediator mediator, String name) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public abstract String getStatus();
}
