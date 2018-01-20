/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author koval
 */
 //sap.phil.v@gmail.com
public class GameSettingsParser {
    
    public static ArrayList<QuestData> quests = new ArrayList<QuestData>();
    public static QuestData firstQuest;

public static QuestData findQuestByID(String questID){
    for (int i = 0; i < quests.size(); i++) {
        QuestData quest = quests.get(i);
        if(quest.id.equals(questID))
            return quest;
    }
    return firstQuest;
}
    
    public static void parse() {
        Scanner in;
        try {
            in = new Scanner(new FileReader("gamesettings.json"));
            String result = "";
            while(in.hasNextLine()){
                result += in.nextLine();
            }
            
            JSONObject some = new JSONObject(result);
            JSONArray rawQuests = (JSONArray)some.get("quests");
                
            for (int i = 0; i < rawQuests.length(); i++) {
                JSONObject someQuest = (JSONObject)rawQuests.get(i);
                QuestData quest = new QuestData(someQuest);
                quests.add(quest);
                 if(firstQuest == null){
                    firstQuest = quest;
                    //System.out.println(quest.text);
                   }

            }
            System.out.println(quests.size());

            for (int i = 0; i < quests.size(); i++) {
                System.out.println(quests.get(i).id + ": " + quests.get(i).text);
                if (quests.get(i).answers.size() > 0){
                    for (int j = 0; j < quests.get(i).answers.size(); j++) {
                        System.out.println(quests.get(i).answers.get(j).targetID + ": " + quests.get(i).answers.get(j).text);
                    }
                }
                System.out.println("");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameSettingsParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(GameSettingsParser.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
    