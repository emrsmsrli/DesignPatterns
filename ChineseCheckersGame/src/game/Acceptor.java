package game;

import game.Visitors.Visitor;

public interface Acceptor {
    void accept(Visitor v);
}
