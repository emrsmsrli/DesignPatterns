class Nurse extends HospitalStaff {

    Nurse(Mediator m, String name) {
        super(m, name);
    }

    TaskResult bringMedicine(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }

    TaskResult takeBloodSample(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }
}
