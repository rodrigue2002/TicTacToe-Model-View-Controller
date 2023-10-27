import processing.core.PApplet;
public class Main2 {
    public static void main(String[]args){
        var model = new TicTacToeModel();
        var view2 = new TicTacToeView2();
        var controller = new TicTacToeController();
        
        controller.setModel(model);
        controller.setView(view2);
        view2.setController(controller);

        PApplet.runSketch(new String[]{"EvolisAdventureView"}, view2
        );
    }
}
