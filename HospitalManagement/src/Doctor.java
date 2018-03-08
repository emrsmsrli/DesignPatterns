class Doctor extends HospitalStaff {

    Doctor(String name) {
        super(name);
    }

    TaskResult performOperation(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }

    TaskResult performVisit(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }

    TaskResult dismissPatient(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }
}
