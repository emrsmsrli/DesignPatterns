import State.State;

public abstract class ObjectWithState extends Producable{
    private String name;
    private State state;

    public ObjectWithState(String name,State state){
        this.name = name;
        this.state = state;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }

    public void printState(){
        System.out.println("State: " + state.getState());
    }

    public String getName() {
        return name;
    }

    public abstract String getAllComponentsName();

    public boolean tick(){
        if(isReady())
            return true;
        else if(isSubComponentsProduced()){
            state = this.getState().tick();
            if(isReady()){
                produce();
                return true;
            }
        } else {
            System.out.print("Sub components are not produced yet. Name: " + getName() + " ");
            printState();
        }
        return false;
    }

    public abstract boolean isSubComponentsProduced();

    public boolean isReady(){
        return state.isReady();
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass() && o.hashCode() == this.hashCode();
    }
}
