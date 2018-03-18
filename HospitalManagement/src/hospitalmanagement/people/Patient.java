package hospitalmanagement.people;

import hospitalmanagement.IMediator;
import hospitalmanagement.Room;
import hospitalmanagement.util.names.Name;

public class Patient extends Person {
    public Patient(IMediator mediator, Name name){
        super(mediator, name);
    }

    @Override
    public void goToRoom(Room room) {
        super.goToRoom(room);
        room.setPatient(this);
    }

    @Override
    public void getOutOfRoom() {
        currentRoom.setPatient(null);
        super.getOutOfRoom();
    }
}
