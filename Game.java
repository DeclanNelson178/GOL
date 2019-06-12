import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game {

    private MenuDisplay menuDisplay;
    private GameDisplay gameDisplay;
    private BufferStrategy bs;
    private Graphics g;

    public int width, height;
    public String title;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;


    }

    public void startGame() {
        menuDisplay = new MenuDisplay(title, width, height);

        while(menuDisplay.getIsOpen()){
            System.out.println("Still working");
        }

        gameDisplay = new GameDisplay(title, width, height);

        int x = 0;
        while(gameDisplay.getIsOpen()){
            System.out.println("Playing the game");
            render(g);
        }


    }

    public void render(Graphics g) {
        bs = gameDisplay.getCanvas().getBufferStrategy();
        if(bs == null) {
            gameDisplay.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        g.clearRect(0,0,width, height);
        gameDisplay.render(g);

        bs.show();
        g.dispose();
    }

    public void closeWindow() {
        //menuDisplay.closeWindow();
    }
}
