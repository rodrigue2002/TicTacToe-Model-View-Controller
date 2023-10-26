interface ITicTacToeController {
    void newGame();
    void controlMove();
    boolean setPlayer1(int a);
    boolean setPlayer2(int a);
    boolean controlGameOverPlayer1();
    boolean controlGameOverPlayer2();
    boolean keinerGewinnt();
    void restart();
}
