package game;

import game.Visitors.Visitor;

public class EmptyNode extends BoardNode {
    @Override
    public void accept(Visitor v) {
        super.accept(v);
    }
}
