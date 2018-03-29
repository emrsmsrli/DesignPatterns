package State;

public class ReadyState extends State{
    public State tick(){
        return this;
    }
    public String getState(){
        return "Ready";
    }
}
