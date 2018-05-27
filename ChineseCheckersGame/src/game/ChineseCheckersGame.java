package game;

public class ChineseCheckersGame {
    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player("Cihan", 1);
        Player player2 = new Player("Emre", 2);
        board.initPlayer1(1);
        board.initPlayerAgainst1(2);
        board.initPlayer2(3);
        board.initPlayerAgainst2(4);
        board.initPlayer3(5);
        board.initPlayerAgainst3(6);
    }
}
