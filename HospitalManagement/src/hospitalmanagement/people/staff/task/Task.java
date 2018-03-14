package hospitalmanagement.people.staff.task;

import hospitalmanagement.HospitalDispatchAndMonitorSystem;

public class Task {
    public enum Result {
        SUCCESS,
        FAILURE
    }

    private float probability = 0;

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public Result execute() {
        return HospitalDispatchAndMonitorSystem.random.nextFloat() < probability ?
                Result.SUCCESS :
                Result.FAILURE;
    }
}
