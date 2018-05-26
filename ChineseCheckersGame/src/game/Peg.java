package game;

import game.Visitors.PegVisitor;

public class Peg {

    public void accept(PegVisitor visitor){
        visitor.visit(this);
    }
}
