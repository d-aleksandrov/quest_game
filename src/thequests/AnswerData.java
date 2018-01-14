/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequests;

/**
 *
 * @author Phil
 */
public class AnswerData {
    private static final String DELIMITER = "`";
    
    public String targetID;
    public String text;
    public AnswerData(String rawStr) {
        int delPos = rawStr.indexOf(DELIMITER);
        targetID = rawStr.substring(0, delPos);
        text = rawStr.substring(delPos+1);
    }
    
}
