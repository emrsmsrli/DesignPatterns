class Doctor extends HospitalStaff {

    Doctor(String name) {
        super(name);
    }

    Enum performOperation(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }

    Enum performVisit(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }

    Enum dismissPatient(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }
}
