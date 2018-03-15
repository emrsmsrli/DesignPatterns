package hospitalmanagement.people;

import hospitalmanagement.IMediator;
import hospitalmanagement.Room;

public class Patient extends Person {
    public Patient(IMediator mediator){
        super(mediator);
    }

    @Override
    public void goToRoom(Room room) {
        super.goToRoom(room);
        room.setPatient(this);
    }

    public void dismiss() {
        currentRoom.setPatient(null);
        currentRoom = null;
    }
}
