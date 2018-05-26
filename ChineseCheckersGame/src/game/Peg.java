package game;

import game.Visitors.Visitor;

public class Peg implements Acceptor {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
