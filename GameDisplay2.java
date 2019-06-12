import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.util.EventListener;


public class GameDisplay2 extends Canvas implements MouseListener {

    Grid grid;
    int dimension = MenuDisplay.getD();
    int x;
    int y;
    public static int size;

    private int width;
    private int height;

    private BufferStrategy bs;

    private boolean firstTime = true;

    JButton set;

    public GameDisplay2(int width, int height) {
        super();

        this.width = width;
        this.height = height;

        int counter = 1;
        while( size < 600) {
            size = dimension * counter;
            counter++;
            System.out.println("Size " + size + " counter " + counter);
        }

        System.out.println(size);
        width = size;
        height = size;

        grid = new Grid(dimension);

        set = new JButton("Set");
        set.setMaximumSize(new Dimension(50,20));

        this.setPreferredSize(new Dimension(width, height));//parameter is a dimension object
        this.setMaximumSize(new Dimension(width, height));
        this.setMinimumSize(new Dimension(width, height));
        this.setFocusable(false);





        JFrame window = new JFrame("Game of Life");
        window.setSize(size,size+100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLayout(new FlowLayout());

        window.setResizable(false);
        window.setLocationRelativeTo(null);

        window.add(this);

        window.add(set);


        addMouseListener(this);

        set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                grid.expand();
                grid.update();
                repaint();


            }
        });
        window.pack();
        setVisible(true);

        window.createBufferStrategy(2);
        bs = window.getBufferStrategy();






    }

    public void paint(Graphics g) {
        if(firstTime){
            grid.render(g);
            firstTime = false;
        }
        BufferStrategy bs = getBufferStrategy(); //Gets the buffer strategy our canvas is currently using
        if(bs == null) { //True if our canvas has no buffer strategy (should only happen once when we first start the game)
            createBufferStrategy(2); //Create a buffer strategy using two buffers (double buffer the canvas)
            return; //Break out of the preDraw method instead of continuing on, this way we have to check again if bs == null instead of just assuming createBufferStrategy(2) worked
        }

        g = bs.getDrawGraphics();
        grid.render(g);
        g.dispose();
        bs.show();





    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getY();
        y = e.getX();


        if ( x>= 0 && x < width && y >= 0 && y < height ){
            Cell c = grid.getCell(e.getY(), e.getX());
         if (c.isAlive()) {
                c.setAlive(true);
            } else {
                c.setAlive(false);
            }
        }
        repaint();
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Cell c = grid.getCell(e.getY(), e.getX());
        if (!c.isAlive()) {
            c.setAlive(true);
        } else {
            c.setAlive(false);
        }
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
