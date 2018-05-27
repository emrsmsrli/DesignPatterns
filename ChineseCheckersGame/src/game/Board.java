package game;

public class Board {
    private BoardNode board[][];

    public Board() {
        initBoard();
    }

    public BoardNode[][] getBoard() {
        return board;
    }

    private void initBoard(){
        board = new BoardNode[17][13];
        initEmptyNodes(0, 1, 2, 3);
        for(int i=4; i<13; i++){
            for(int j=0; j<13; j++) {
                board[i][j] = new EmptyNode();
            }
        }
        initEmptyNodes(16, 15, 14, 13);
    }

    private void initEmptyNodes(int i, int i2, int i3, int i4) {
        board[i][6]  = new EmptyNode();
        board[i2][5] = new EmptyNode();
        board[i2][7] = new EmptyNode();
        board[i3][4] = new EmptyNode();
        board[i3][6] = new EmptyNode();
        board[i3][8] = new EmptyNode();
        board[i4][4] = new EmptyNode();
        board[i4][5] = new EmptyNode();
        board[i4][7] = new EmptyNode();
        board[i4][8] = new EmptyNode();
    }

    private void initPlayer1(int color){
        initPlayers(color, 0, 1, 2, 3);
    }
    private void initPlayerAgainst1(int color){
        initPlayers(color, 16, 15, 14, 13);
    }
    private void initPlayers(int color, int i, int i2, int i3, int i4) {
        board[i][6] = new Peg(color);
        board[i2][5] = new Peg(color);
        board[i2][7] = new Peg(color);
        board[i3][4] = new Peg(color);
        board[i3][6] = new Peg(color);
        board[i3][8] = new Peg(color);
        board[i4][4] = new Peg(color);
        board[i4][5] = new Peg(color);
        board[i4][7] = new Peg(color);
        board[i4][8] = new Peg(color);
    }

    private void initPlayer2(int color){
        board[4][0] = new Peg(color);
        board[4][1] = new Peg(color);
        board[4][2] = new Peg(color);
        board[4][3] = new Peg(color);
        board[5][0] = new Peg(color);
        board[5][1] = new Peg(color);
        board[5][2] = new Peg(color);
        board[6][0] = new Peg(color);
        board[6][1] = new Peg(color);
        board[7][0] = new Peg(color);
    }
    private void initPlayerAgainst2(int color){
        board[9][12] = new Peg(color);
        board[10][11] = new Peg(color);
        board[10][12] = new Peg(color);
        board[11][10] = new Peg(color);
        board[11][11] = new Peg(color);
        board[11][12] = new Peg(color);
        board[12][9] = new Peg(color);
        board[12][10] = new Peg(color);
        board[12][11] = new Peg(color);
        board[12][12] = new Peg(color);
    }

    private void initPlayer3(int color){
        board[4][9] = new Peg(color);
        board[4][10] = new Peg(color);
        board[4][11] = new Peg(color);
        board[4][12] = new Peg(color);
        board[5][10] = new Peg(color);
        board[5][11] = new Peg(color);
        board[5][12] = new Peg(color);
        board[6][11] = new Peg(color);
        board[6][12] = new Peg(color);
        board[7][12] = new Peg(color);
    }
    private void initPlayerAgainst3(int color){
        board[9][0] = new Peg(color);
        board[10][0] = new Peg(color);
        board[10][1] = new Peg(color);
        board[11][0] = new Peg(color);
        board[11][1] = new Peg(color);
        board[11][2] = new Peg(color);
        board[12][0] = new Peg(color);
        board[12][1] = new Peg(color);
        board[12][2] = new Peg(color);
        board[12][3] = new Peg(color);
    }
}
/*
    * * * * * * P * * * * * *
    * * * * * P * P * * * * *
    * * * * P * P * P * * * *
    * * * * P P * P P * * * *
    P P P P o o o o o P P P P
    P P P o o o o o o o P P P
    P P o o o o o o o o o P P
    P o o o o o o o o o o o P
    o o o o o o o o o o o o o
    P o o o o o o o o o o o P
    P P o o o o o o o o o P P
    P P P o o o o o o o P P P
    P P P P o o o o o P P P P
    * * * * P P * P P * * * *
    * * * * P * P * P * * * *
    * * * * * P * P * * * * *
    * * * * * * P * * * * * *
* */