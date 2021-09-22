package gui;

import actions.ActionHandler;
import actions.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui {
    JFrame jf;
    Draw d;
    public static JButton btnexit, btnsave;

    public static int screenwidth = 800, screenheight = 600;
    public static int xoff = 130, yoff = 20;

    public void create() {
        jf = new JFrame();
        jf.setSize(screenwidth, screenheight);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setTitle("Snake");
        jf.setResizable(false);
        jf.addKeyListener(new KeyHandler());
        jf.requestFocus();
        jf.setVisible(true);



        //Exit Button
        btnexit = new JButton();
        btnexit.setText("Exit");
        btnexit.setBounds(680, 475, 50, 25);
        btnexit.setVisible(true);
        btnexit.addActionListener(new ActionHandler());
        btnexit.setBackground(Color.LIGHT_GRAY);
        btnexit.setFont(new Font("Arial", Font.BOLD, 20));
        btnexit.setForeground(Color.BLACK);
        btnexit.setBorder(null);
        btnexit.setFocusPainted(false);
        btnexit.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {
                btnexit.setBackground(Color.WHITE);
                btnexit.setForeground(Color.LIGHT_GRAY);
            }

            public void mouseExited(MouseEvent evt) {
                btnexit.setBackground(Color.LIGHT_GRAY);
                btnexit.setForeground(Color.BLACK);
            }
        });
        jf.add(btnexit);
        jf.requestFocus();

        // Save Button
        btnsave = new JButton();
        btnsave.setText("Save");
        btnsave.setBounds(30, 475, 50, 25);
        btnsave.setVisible(true);
        btnsave.addActionListener(new ActionHandler());
        btnsave.setBackground(Color.LIGHT_GRAY);
        btnsave.setFont(new Font("Arial", Font.BOLD, 20));
        btnsave.setForeground(Color.BLACK);
        btnsave.setBorder(null);
        btnsave.setFocusPainted(false);
        btnsave.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent evt) {
                btnsave.setBackground(Color.WHITE);
                btnsave.setForeground(Color.LIGHT_GRAY);
            }

            public void mouseExited(MouseEvent evt) {
                btnsave.setBackground(Color.LIGHT_GRAY);
                btnsave.setForeground(Color.BLACK);
            }
        });
        jf.add(btnsave);

        d = new Draw();
        d.setBounds(0,0,screenwidth,screenheight);
        d.setVisible(true);
        jf.add(d);

        jf.requestFocus();
        jf.setVisible(true);
    }
}
