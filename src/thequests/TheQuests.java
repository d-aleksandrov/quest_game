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
public class TheQuests {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameSettingsParser GSP = new GameSettingsParser();
        GSP.parse();
    }
    
}
