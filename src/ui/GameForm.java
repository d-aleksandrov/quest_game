package ui;

import data.AnswerData;
import data.GameSettingsParser;
import data.QuestData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameForm extends JFrame {
    private JPanel root;

    private Image nativeDraw = new Image(Resources.BACK);

    private ArrayList<Image> buttons = new ArrayList<>();
    private ArrayList<AnswerData> answers;

    public GameForm() {
        root.setLayout(new GroupLayout(root));
        setContentPane(root);
        pack();
        setVisible(true);

        Dimension stPos = new Dimension(50, 200);
        for (int i = 0; i < Sizes.ANSWERS_COUNT; i++) {
            Image btn = new Image(Resources.BUTTON);
            btn.set_pos(stPos);
            stPos.height += btn.get_size().height + 10;
            btn.addActionListener(elt -> processAnswer(elt));
            buttons.add(btn);
            root.add(btn);
        }

        root.add(nativeDraw);
    }

    private void processAnswer(JPanel btn) {
        AnswerData answerData = answers.get(buttons.indexOf(btn));
        QuestData newQuest = GameSettingsParser.findQuestByID(answerData.targetID);
        initQuest(newQuest);
    }

    public void initQuest(QuestData quest) {
        nativeDraw.text = quest.text;
        answers = quest.answers;

        for (int i = 0; i < quest.answers.size(); i++) {
            Image btn = buttons.get(i);
            AnswerData answer = quest.answers.get(i);
            btn.text = answer.text;
        }
        root.updateUI();
    }
}
