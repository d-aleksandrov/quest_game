import data.GameSettingsParser;
import ui.GameForm;
import ui.StartScreenForm;
import utils.GlobalTimer;
import utils.TestTickElement;

import javax.swing.*;

public class QuestGame {

    public static void main(String[] args){
        System.out.println("hello");

        GameSettingsParser GSP = new GameSettingsParser();
        GSP.parse();

        StartScreenForm mainQuestWindow = new StartScreenForm();
        GlobalTimer.initialize(30);


    //    mainQuestWindow.initQuest(GameSettingsParser.firstQuest);
    }
}
