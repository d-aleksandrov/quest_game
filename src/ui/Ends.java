package ui;

import data.GameSettingsParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Ends extends JFrame{
    private Image splash = new Image(Resources.BACK);
    private JPanel root;

    public Ends() {
        setContentPane(root);
        root.setLayout(new GroupLayout(root));

        pack();
        setVisible(true);

        Dimension pos = new Dimension(10, 10);

        Image back = new Image(Resources.BUTTON);
        back.set_pos(pos);
        back.text = "<--";
        back.addActionListener( l -> goToStart());
        root.add(back);
        pos.height += back.get_size().height;

        root.add(splash);
    }

    private void goToStart() {
        StartScreenForm main = new StartScreenForm();

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
