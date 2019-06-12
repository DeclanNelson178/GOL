import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        //Game game = new Game("Conway's Game of Life", 1000,1000);
        //game.startGame();
        MenuDisplay menuDisplay = new MenuDisplay("Conway's Game of Life", 1000,1000);
        while(menuDisplay.getIsOpen()){
            System.out.println("Still working");
        }
        int dimension = menuDisplay.getD();
        GameDisplay2 gameDisplay2 = new GameDisplay2(250,250);








    }
}
