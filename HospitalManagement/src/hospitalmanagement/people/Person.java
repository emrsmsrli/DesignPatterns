package hospitalmanagement.people;

import hospitalmanagement.IMediator;
import hospitalmanagement.Room;
import hospitalmanagement.util.names.Name;

public abstract class Person {
    public Name name;

    protected IMediator mediator;
    protected Room currentRoom;

    public Person(IMediator mediator, Name name) {
        this.mediator = mediator;
        this.name = name;
        this.currentRoom = null;
    }

    public void goToRoom(Room room) {
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
