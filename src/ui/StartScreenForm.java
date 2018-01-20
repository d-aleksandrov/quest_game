package ui;

import data.GameSettingsParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class StartScreenForm extends JFrame {
    private Image splash = new Image(Resources.BACK);
    private JPanel root;

    public StartScreenForm() {
        setContentPane(root);
        root.setLayout(new GroupLayout(root));

        pack();
        setVisible(true);

        Dimension pos = new Dimension(50, 250);

        Image quest = new Image(Resources.BUTTON);
        quest.set_pos(pos);
        quest.text = "Квесты";
        quest.addActionListener( l -> goToQuest());
        root.add(quest);
        pos.height += quest.get_size().height;

        Image ends = new Image(Resources.BUTTON);
        ends.set_pos(pos);
        ends.text = "Концовки";
        ends.addActionListener( l -> goToEnds());
        root.add(ends);

        root.add(splash);
    }

    private void goToEnds() {
        new Ends();
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void goToQuest() {
        GameForm main = new GameForm();
        main.initQuest(GameSettingsParser.firstQuest);

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

}
