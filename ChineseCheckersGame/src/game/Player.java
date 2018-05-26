package game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int pegColor;
    private List<Peg> pegs;

    Player(String name, int pegColor){
        createPegs(pegColor);
        this.name = name;
        this.pegColor = pegColor;
    }

    public int getPegColor() {
        return pegColor;
    }

    public String getName() {
        return name;
    }

    public List<Peg> getPegs() {
        return pegs;
    }

    public void removePeg(Peg peg){
        pegs.remove(peg);
    }

    private void createPegs(int color){
        pegs = new ArrayList<>(10);
        for(int i=0; i<10; i++){
            pegs.add(new Peg(color));
        }
    }
}