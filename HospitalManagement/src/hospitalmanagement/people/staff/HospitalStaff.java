package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.Room;
import hospitalmanagement.people.Person;
import hospitalmanagement.people.staff.task.Task;

public abstract class HospitalStaff extends Person {
    private Room currentRoom = null;

    public HospitalStaff(IMediator mediator) {
        super(mediator);
    }

    @Override
    public void goToRoom(Room room) {
        super.goToRoom(room);
        room.setStaff(this);
    }

    public void getOutOfRoom() {
        currentRoom.setStaff(null);
        currentRoom = null;
    }

    public abstract Task.Result executeTask(Task task);
}