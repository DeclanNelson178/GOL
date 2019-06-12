import javax.swing.*;
import java.awt.*;

public class Display {

    protected JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    private boolean isOpen;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        isOpen = true;

        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);//puts frame in the middle of the screen


        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));//parameter is a dimension object
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);

    }

    public void closeWindow() {
        frame.dispose();
        isOpen = false;
    }

    public boolean getIsOpen(){
        return isOpen;
    }
}
