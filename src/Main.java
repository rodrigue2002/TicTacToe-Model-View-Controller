import processing.core.PApplet;

public class Main {
    public static void main(String[] args) {
        var model = new TicTacToeModel();
        var controller = new TicTacToeController();
        var view = new TicTacToeView();

        // Connect M, V and C
        controller.setModel(model);
        controller.setView(view);
        view.setController(controller);

        // Starts the processing application
        PApplet.runSketch(new String[]{"EvolisAdventureView"}, view);
    }
}
