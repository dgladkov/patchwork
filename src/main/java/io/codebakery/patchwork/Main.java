package io.codebakery.patchwork;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class Main extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private DragListener dragListener = new DragListener();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {

        Main frame = new Main();
        frame.setVisible(true);

    }

    /**
     * Create the frame.
     */
    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();

        this.setUndecorated(true);

        this.addMouseListener(dragListener);
        this.addMouseMotionListener(dragListener);

    }

    public class DragListener extends MouseInputAdapter
    {
        int posX = 0, posY = 0;

        public void mousePressed(MouseEvent e)
        {
            posX = e.getX();
            posY = e.getY();
        }

        public void mouseDragged(MouseEvent evt)
        {
            setLocation(
                evt.getXOnScreen() - posX,
                evt.getYOnScreen() - posY
            );

        }
    }
}