class PatientCompanion extends HospitalStaff {

    PatientCompanion(String name) {
        super(name);
    }

    Enum takePatientToMRI(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }

    Enum takePatientToXRAY(){
        return TaskResult.values()[randomTask.nextInt(TaskResult.values().length)];
    }
}
