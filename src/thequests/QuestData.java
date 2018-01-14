/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequests;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 *
 * @author Phil
 */
public class QuestData extends BaseDataObject {

    public String id;
    public String text;
    
    ArrayList<AnswerData> answers = new ArrayList<AnswerData>();
    
    public QuestData(JSONObject rawData) {
        super(rawData);

        id = str("id");
        text = str("text");

        JSONArray rawAnswers = arr("answers");
        for (int i = 0; i < rawAnswers.length(); i++) {
            String rawAnswer;
            try {
                rawAnswer = rawAnswers.getString(i);
                answers.add(new AnswerData(rawAnswer));
            } catch (JSONException ex) {
                Logger.getLogger(QuestData.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
