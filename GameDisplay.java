import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class GameDisplay implements MouseListener {

    protected JFrame frame;
    protected JPanel panel;
    private Canvas canvas;

    private String title;
    private int width, height;

    private Grid grid;

    private boolean isOpen;

    public GameDisplay(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        isOpen = true;

        frame = new JFrame(title);
        panel = new JPanel();
        frame.setSize(width, height+100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);//puts frame in the middle of the screen


        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));//parameter is a dimension object
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);


        frame.pack();
        frame.setVisible(true);

        addMouseListener(this);


    }

    public Canvas getCanvas() {
        return canvas;
    }

    public boolean getIsOpen(){
        return isOpen;
    }

    public void render(Graphics g) {
        grid = new Grid(MenuDisplay.getD());
        grid.render(g);
        //g.drawRect(0,0,100,100);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
