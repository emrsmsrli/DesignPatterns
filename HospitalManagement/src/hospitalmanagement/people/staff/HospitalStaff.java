package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.Room;
import hospitalmanagement.people.Person;
import hospitalmanagement.people.staff.task.Task;
import hospitalmanagement.util.names.Name;

public abstract class HospitalStaff extends Person {
    private Room currentRoom = null;

    public HospitalStaff(IMediator mediator, Name name) {
        super(mediator, name);
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

    public void reportToHospital(Task t, Task.Result tr) {
        mediator.report(getCurrentRoom(), t, tr);
    }

    public abstract void executeTask(int taskId);
}