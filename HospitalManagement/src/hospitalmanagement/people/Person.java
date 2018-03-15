package hospitalmanagement.people;

import hospitalmanagement.IMediator;
import hospitalmanagement.Room;

public abstract class Person {
    protected IMediator mediator;
    protected Room currentRoom;

    public Person(IMediator mediator) {
        this.mediator = mediator;
        this.currentRoom = null;
    }

    public void goToRoom(Room room) {
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
