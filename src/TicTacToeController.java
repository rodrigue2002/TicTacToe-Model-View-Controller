public class TicTacToeController implements ITicTacToeController{
    private TicTacToeModel model;
    private ITicTacToeView view;

    public TicTacToeController(){}
    
    public void setModel(TicTacToeModel model) {
        this.model = model;
    }

    public void setView(ITicTacToeView view) {
        this.view = view;
    }
    public void controlMove(){
        model.move(view.getControlMouse());
    }
    public void newGame(){
        model.newGame();

    }
    public boolean setPlayer1(int a){
        return model.getBoard()[a] == model.PLAYER_1;
    }
    public boolean setPlayer2(int a){
            return model.getBoard()[a] == model.PLAYER_2;
        }
    public boolean controlGameOverPlayer1(){
        return model.hasPlayer1Won();
    }
    public boolean controlGameOverPlayer2(){
        return model.hasPlayer2Won();
    }
    public boolean keinerGewinnt(){
        return(!model.hasPlayer1Won() && !model.hasPlayer2Won() && model.moveCount >= model.getBoard().length);
    }
    public void restart(){
        for(int i = 0; i< model.getBoard().length; i++){
            model.getBoard()[i] = model.EMPTY;
        }
        model.moveCount =0;
    }
}
    

