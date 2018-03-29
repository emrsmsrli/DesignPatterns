package State;

public abstract class State {
    public abstract State tick();
    public abstract String getState();

    public boolean isReady(){
        return this instanceof ReadyState;
    }
}
