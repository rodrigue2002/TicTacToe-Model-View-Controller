import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;
public class TicTacToeView extends PApplet implements ITicTacToeView{
    private ITicTacToeController controller;
    public PImage player1;
    PImage player2;
    private int controlMouse;
    public TicTacToeView(){
    }
    public int getControlMouse(){
        return controlMouse;
    }
     public void setController(ITicTacToeController controller) {
        this.controller = controller;
    }
    public void settings(){
        size(600,600);
        displayDensity((int)2);   
    }
    public void setup(){
        player1 = loadImage("/images/035.png");
        player2 = loadImage("/images/114.png");
        controller.newGame();
    }
    public void draw(){
        if(!controller.controlGameOverPlayer1() || !controller.controlGameOverPlayer2()){
            drawTableau();
            controlSetPlayer();
        }
        winner();
        loser();
    }
    public void drawTableau(){
        image(loadImage("/images/pokemon.jpg"),0,0,600,600);
        //background(0);
        stroke(255);
        line(200,0,200,600);
        line(400,0,400,600);
        line(600,0,600,600);
        line(0,200,600,200);
        line(0,400,600,400);
        line(0,600,600,600);
    }
    public void mousePressed(){
        if(mouseX < 200 && mouseY<200){
            controlMouse =0;
            controller.controlMove();
        }
        if(mouseX >200 && mouseX <400 && mouseY < 200 ){
            controlMouse = 1;
            controller.controlMove();
        }
        if(mouseX >400 && mouseX <600 && mouseY < 200){
            controlMouse = 2;
            controller.controlMove();
        }
        if(mouseX <200  && mouseY > 200 && mouseY<400){
            controlMouse = 3;
            controller.controlMove();
        }
        if(mouseX >200 && mouseX < 400  && mouseY > 200 && mouseY<400){
             controlMouse = 4;
            controller.controlMove();
        }
        if(mouseX >400  && mouseY > 200 && mouseY<400){
            controlMouse = 5;
            controller.controlMove();
        }
        if(mouseX <200  && mouseY > 400 && mouseY<600){
            controlMouse = 6;
            controller.controlMove();
        }
        if(mouseX >200 && mouseX <400  && mouseY > 400 && mouseY<600){
             controlMouse = 7;
            controller.controlMove();
        }
        if(mouseX >400  && mouseY > 400){
            controlMouse = 8;
            controller.controlMove();
        }

    }
    public void controlSetPlayer(){
        for(int i = 0; i<9; i++){
            if(controller.setPlayer1(i) && i == 0) image(player1,0,0,200,200);
            if(controller.setPlayer1(i) && i == 1) image(player1,200,0,200,200);
            if(controller.setPlayer2(i)&& i == 0) image(player2,0,0,200,200);
            if(controller.setPlayer2(i)&& i == 1) image(player2,200,0,200,200);
            if(controller.setPlayer1(i) && i == 2) image(player1,400,0,200,200);
            if(controller.setPlayer2(i)&& i == 2) image(player2,400,0,200,200);
            if(controller.setPlayer1(i) && i == 3) image(player1,0,200,200,200);
            if(controller.setPlayer2(i)&& i == 3) image(player2,0,200,200,200);
            if(controller.setPlayer1(i) && i == 4) image(player1,200,200,200,200);
            if(controller.setPlayer2(i)&& i == 4) image(player2,200,200,200,200);
            if(controller.setPlayer1(i) && i == 5) image(player1,400,200,200,200);
            if(controller.setPlayer2(i)&& i == 5) image(player2,400,200,200,200);
            if(controller.setPlayer1(i) && i == 6) image(player1,0,400,200,200);
            if(controller.setPlayer2(i)&& i == 6) image(player2,0,400,200,200);
            if(controller.setPlayer1(i) && i == 7) image(player1,200,400,200,200);
            if(controller.setPlayer2(i)&& i == 7) image(player2,200,400,200,200);
            if(controller.setPlayer1(i) && i == 8) image(player1,400,400,200,200);
            if(controller.setPlayer2(i)&& i == 8) image(player2,400,400,200,200);
            
        }
    }
    public void winner(){
        textSize(50);
        if(controller.controlGameOverPlayer1()){
            background(0);
            image(loadImage("/images/035.png"),150,0,300,300);
            fill(255,255,0);
            text("PLAYER_1 HAT GEWONNEN",5,350);
            fill(255,0,0);
            text("click r to replay",150,400);
        }
        if(controller.controlGameOverPlayer2()){
            background(0);
            image(loadImage("/images/114.png"),150,0,300,300);
            fill(255,255,0);
            text("PLAYER_2 HAT GEWONNEN",5,350);
            fill(255,0,0);
            text("click r to replay",150,400);
        }
    }
    public void loser(){
        if(controller.keinerGewinnt()) {
            background(0);
            fill(255,255,0);
            text("BEIDE LOSER",180,200);
            fill(255,0,0);
            text("click r to replay",150,250);
        }
    }
    public void keyPressed(KeyEvent event){
        if(event.getKeyCode() == 'R'){
            controller.restart();
            draw();
        }
    }
}
