package game;

import game.Visitors.Visitor;

public class Peg extends BoardNode implements Acceptor {
    private int color;

    Peg(int color){
        this.color = color;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public int getColor() {
        return color;
    }
}
