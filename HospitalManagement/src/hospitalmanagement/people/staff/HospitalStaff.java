package hospitalmanagement.people.staff;

import hospitalmanagement.IMediator;
import hospitalmanagement.Room;
import hospitalmanagement.people.Patient;
import hospitalmanagement.people.Person;
import hospitalmanagement.people.staff.task.Task;
import hospitalmanagement.util.names.Name;

public abstract class HospitalStaff extends Person {
    public HospitalStaff(IMediator mediator, Name name) {
        super(mediator, name);
    }

    @Override
    public void goToRoom(Room room) {
        super.goToRoom(room);
        room.setStaff(this);
    }

    @Override
    public void getOutOfRoom() {
        currentRoom.setStaff(null);
        super.getOutOfRoom();
    }

    public void reportToHospital(Patient p, Task t, Task.Result tr) {
        mediator.report(this, p, t, tr);
    }

    public abstract void executeTask(int taskId);
}