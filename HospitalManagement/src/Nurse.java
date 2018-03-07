class Nurse extends HospitalStaff {

    Nurse(String name) {
        super(name);
    }

    public Enum bringMedicine(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }

    public Enum takeBloodSample(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }
}
