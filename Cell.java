import javax.swing.*;
import java.awt.*;

public class Cell {

    private boolean alive;
    private Color color;
    private int x;
    private int y;
    public static int side;

    public Cell(boolean alive, int x, int y) {
        this.alive = alive;
        this.x = x;
        this.y = y;
        setColor(alive);



    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        setColor(alive);
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public static int getSide() {
        return side;
    }

    public void setColor(boolean alive) {
        if(alive) {
            color = new Color(0,128,0);
        }
        else {
            color = new Color(255,255,255);
        }
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect(x,y,side,side);
        g.setColor(new Color(0,0,0));
        g.drawRect(x,y,side,side);
    }

    public static void setSide(int length) {
        side = length;
    }




}
