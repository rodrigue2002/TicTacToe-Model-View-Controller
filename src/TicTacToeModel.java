/**
 * A basic model to play Tic Tac Toe with two players. Supports basic JShell output.
 *
 * Example:
 * jshell> /open TicTacToeModel.java *
 * jshell> var game = new TicTacToeModel()
 * game ==> Make move for X
 * _ _ _
 * _ _ _
 * _ _ _
 *
 * jshell> game.move(1)
 * Make move for O
 * _ X _
 * _ _ _
 * _ _ _
 *
 * jshell> game.move(4)
 * Make move for X
 * _ X _
 * _ O _
 * _ _ _
 */
public class TicTacToeModel {
    /* The default field entry for empty fields */
    public final char EMPTY = '_';
    /* The mark of player 1 on the playing field */
    public final char PLAYER_1 = 'X';
    /* The mark of player 2 on the playing field */
    public final char PLAYER_2 = 'O';

    /* Playing field with 9 entries */
    private char[] gameState;

    /* Counts the moves. Even moves are for PLAYER_1; odd moves are for PLAYER_2. */
    public char moveCount = 0;

    /*public static void main(String[] args) {
        var game = new TicTacToeModel();
        game.move(1);
        game.move(2);
        game.move(4);
        System.out.println("Field 4 is: "+ game.getFieldEntry(4));
    }*/

    public TicTacToeModel() {
        newGame();
    }

    public void newGame() {
        gameState = new char[]
                {EMPTY, EMPTY, EMPTY,
                 EMPTY, EMPTY, EMPTY,
                 EMPTY, EMPTY, EMPTY};
        moveCount = 0;
    }

    public char getFieldEntry(int field) {  // pour voie lelement a a position field
        if(isValidFieldIndex(field))    // si le nombre est  compri entre 0 et 9
            return gameState[field];
        else
            throw new IndexOutOfBoundsException("Valid fields are [0, 8]");
    }

    public char[] getBoard() {    // il retourne lespace de jeu montrant ainsi les case deja occupé soit par les rond ou les X
        return gameState;
    }

    public boolean isValidFieldIndex(int field) {  // si le nombre est  compri entre 0 et 9
        return field >= 0 && field < gameState.length;
    }

    public boolean isEmptyField(int field) {    // IL VERIFIE si la case a la position field est vide ou pas 
        if(isValidFieldIndex(field))
            return gameState[field] == EMPTY;
        else
            throw new IndexOutOfBoundsException("Valid fields are [0, 8]");
    }

    public char getActivePlayer() {
        return (moveCount % 2 == 0) ? PLAYER_1 : PLAYER_2; // il retourne le joueur qui est a son tour de jouer le 1 si cest pair et le 2 impair
    }

    public void move(int field) {  // verifie si le joueur peux pousser son pion a la case field si ou il le met laba
        if(!isGameOver()) {
            if (!isValidFieldIndex(field))
                throw new IndexOutOfBoundsException("Valid fields are [0, 8]");
            if (!isEmptyField(field))
                throw new RuntimeException("The chosen field is already taken");

            gameState[field] = getActivePlayer();
            moveCount++;

            // Print the state after the move. For easier play inside the JShell.
            System.out.println(this);
        } else
            throw new RuntimeException("The game is already over. Please start a new game.");
    }

    public boolean isGameOver() {
        return hasPlayer1Won() || hasPlayer2Won() || moveCount >= gameState.length;
    }

    public boolean hasPlayer1Won() {  // retourne oui si 
        return checkWinCondition(PLAYER_1); // player 1 a ses pions alligné
    }

    public boolean hasPlayer2Won() { // retourne true si player 2 a ses pions alligné
        return checkWinCondition(PLAYER_2);
    }

    private boolean checkWinCondition(char player) {  // pour voir si le joueur 1 a  ses pions alligné
        return  // Check rows
                (gameState[0] == player && gameState[1] == player && gameState[2] == player) ||
                (gameState[3] == player && gameState[4] == player && gameState[5] == player) ||
                (gameState[6] == player && gameState[7] == player && gameState[8] == player) ||
                // Check columns
                (gameState[0] == player && gameState[3] == player && gameState[6] == player) ||
                (gameState[1] == player && gameState[4] == player && gameState[7] == player) ||
                (gameState[2] == player && gameState[5] == player && gameState[8] == player) ||
                // Check diagonals
                (gameState[0] == player && gameState[4] == player && gameState[8] == player) ||
                (gameState[2] == player && gameState[4] == player && gameState[6] == player);
    }

    @Override
    public String toString() {
        return String.format("%s\n%c %c %c\n%c %c %c\n%c %c %c",
                isGameOver() ? "Game Over" : "Make move for "+getActivePlayer(),
                gameState[0], gameState[1], gameState[2],
                gameState[3], gameState[4], gameState[5],
                gameState[6], gameState[7], gameState[8]);
    }
}
