import java.util.List;

public class PartState {
    private int ordered;
    private int inQualityControl;
    private int ready;

    public PartState(int orderedProcess, int qualityControlProcess){
        ordered = orderedProcess;
        inQualityControl = qualityControlProcess;
    }
}

/*
class State1 {
    public void tick(){
        if(duration == 0)
            return new State2();
    }
}

class State2 {
    public void tick() {
        if(duration == 0)
            return new State1();
    }

}
*/