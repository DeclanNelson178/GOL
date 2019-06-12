import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDisplay {
    private JFrame frame;
    private JButton set;
    private JLabel dim;

    private JLabel intro;
    private JTextField dimEnter;

    public static int d;

    private boolean isOpen;
    //can use the method getText()

    public MenuDisplay(String title, int height, int width) {
        isOpen = true;

        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        intro = new JLabel("Welcome to Conway's Game of Life!");
        intro.setAlignmentX(Component.CENTER_ALIGNMENT);

        set = new JButton("Set Dimensions");
        set.setAlignmentX(Component.CENTER_ALIGNMENT);

        dim = new JLabel("Dimensions:");
        dim.setAlignmentX(Component.CENTER_ALIGNMENT);



        dimEnter = new JTextField(10);
        dimEnter.setAlignmentX(Component.CENTER_ALIGNMENT);
        dimEnter.setMaximumSize(dimEnter.getPreferredSize());



        frame.add(intro);
        frame.add(dim);
        frame.add(dimEnter);

        frame.add(set);
        frame.setLayout(new BoxLayout(frame.getContentPane(),3));

        frame.pack();
        frame.setVisible(true);

        set.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String s = dimEnter.getText();
                d = Integer.parseInt(s);
                if(d > 0) {
                    frame.dispose();
                    isOpen = false;
                }


            }
        });





    }

    public static int getD() {
        return d;
    }


    public boolean getIsOpen() {
        return isOpen;
    }


}
