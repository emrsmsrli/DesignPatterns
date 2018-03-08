class PatientCompanion extends HospitalStaff {

    PatientCompanion(String name) {
        super(name);
    }

    TaskResult takePatientToMRI(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }

    TaskResult takePatientToXRAY(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }
}
