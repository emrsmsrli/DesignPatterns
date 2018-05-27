package game;

public class Board {
    private BoardNode board[][];

    public Board() {
        initBoard();
    }

    public BoardNode[][] getBoard() {
        return board;
    }

    @Override
    public String toString() {
        // todo print board
        return super.toString();
    }

    private void initBoard() {
        board = new BoardNode[17][25];
        initEmptyNodes(0, 1, 2, 3);
        for (int i = 4; i <= 8; i++) {
            for (int j = (i - 4); j < 29-i; j += 2) {
                board[i][j] = new EmptyNode();
            }
        }
        for (int i = 12; i > 8; i--) {
            for (int j = (i - 4); j < 29-i; j += 2) {
                board[i][j] = new EmptyNode();
            }
        }
        initEmptyNodes(16, 15, 14, 13);
    }

    private void initEmptyNodes(int i, int i2, int i3, int i4) {
        board[i][12] = new EmptyNode();
        board[i2][11] = new EmptyNode();
        board[i2][13] = new EmptyNode();
        board[i3][10] = new EmptyNode();
        board[i3][12] = new EmptyNode();
        board[i3][14] = new EmptyNode();
        board[i4][9] = new EmptyNode();
        board[i4][11] = new EmptyNode();
        board[i4][13] = new EmptyNode();
        board[i4][15] = new EmptyNode();
    }

    public void initPlayer1(int color) {
        initPlayer1VS6(color, 0, 1, 2, 3);
    }

    public void initPlayerAgainst1(int color) {
        initPlayer1VS6(color, 16, 15, 14, 13);
    }

    public void initPlayer2(int color) {
        initPlayer2And4(color, 4, 5, 6, 7);
    }

    public void initPlayerAgainst2(int color) {
        initPlayer3And5(color, 12, 11, 10, 9);
    }

    public void initPlayer3(int color) {
        initPlayer3And5(color, 4, 5, 6, 7);
    }

    public void initPlayerAgainst3(int color) {
        initPlayer2And4(color, 12, 11, 10, 9);
    }

    private void initPlayer1VS6(int color, int i, int i2, int i3, int i4) {
        board[i][12] = new Peg(color);
        board[i2][11] = new Peg(color);
        board[i2][13] = new Peg(color);
        board[i3][10] = new Peg(color);
        board[i3][12] = new Peg(color);
        board[i3][14] = new Peg(color);
        board[i4][9]  = new Peg(color);
        board[i4][11] = new Peg(color);
        board[i4][13] = new Peg(color);
        board[i4][15] = new Peg(color);
    }

    private void initPlayer2And4(int color, int i, int i2, int i3, int i4) {
        board[i][0] = new Peg(color);
        board[i][2] = new Peg(color);
        board[i][4] = new Peg(color);
        board[i][6] = new Peg(color);
        board[i2][1] = new Peg(color);
        board[i2][3] = new Peg(color);
        board[i2][5]  = new Peg(color);
        board[i3][2] = new Peg(color);
        board[i3][4] = new Peg(color);
        board[i4][3] = new Peg(color);
    }

    private void initPlayer3And5(int color, int i, int i2, int i3, int i4) {
        board[i][18] = new Peg(color);
        board[i][20] = new Peg(color);
        board[i][22] = new Peg(color);
        board[i][24] = new Peg(color);
        board[i2][19] = new Peg(color);
        board[i2][21] = new Peg(color);
        board[i2][23]  = new Peg(color);
        board[i3][20] = new Peg(color);
        board[i3][22] = new Peg(color);
        board[i4][21] = new Peg(color);
    }
}
/*
    * * * * * * * * * * * * 1 * * * * * * * * * * * *
    * * * * * * * * * * * 1 * 1 * * * * * * * * * * *
    * * * * * * * * * * 1 * 1 * 1 * * * * * * * * * *
    * * * * * * * * * 1 * 1 * 1 * 1 * * * * * * * * *
    2 * 2 * 2 * 2 * _ * _ * _ * _ * _ * 3 * 3 * 3 * 3
    * 2 * 2 * 2 * _ * _ * _ * _ * _ * _ * 3 * 3 * 3 *
    * * 2 * 2 * _ * _ * _ * _ * _ * _ * _ * 3 * 3 * *
    * * * 2 * _ * _ * _ * _ * _ * _ * _ * _ * 3 * * *
    * * * * _ * _ * _ * _ * _ * _ * _ * _ * _ * * * *
    * * * 4 * _ * _ * _ * _ * _ * _ * _ * _ * 5 * * *
    * * 4 * 4 * _ * _ * _ * _ * _ * _ * _ * 5 * 5 * *
    * 4 * 4 * 4 * _ * _ * _ * _ * _ * _ * 5 * 5 * 5 *
    4 * 4 * 4 * 4 * _ * _ * _ * _ * _ * 5 * 5 * 5 * 5
    * * * * * * * * * 6 * 6 * 6 * 6 * * * * * * * * *
    * * * * * * * * * * 6 * 6 * 6 * * * * * * * * * *
    * * * * * * * * * * * 6 * 6 * * * * * * * * * * *
    * * * * * * * * * * * * 6 * * * * * * * * * * * *

* */