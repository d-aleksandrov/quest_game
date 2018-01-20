/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Phil
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDataObject {

    protected JSONObject rawData;
    
    public BaseDataObject(JSONObject rawData) {
        this.rawData = rawData;
    }
    
    protected String str(String key){
        if(rawData.has(key)){
            try {
                Object some = rawData.get(key);
                return some.toString();
            } catch (JSONException ex) {
                Logger.getLogger(BaseDataObject.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } else
            return null;
    }
   
    protected JSONArray arr(String key){
        if (rawData.toMap().size() > 2){
            try {
                return (JSONArray)rawData.get(key);
            } catch (JSONException ex) {
                Logger.getLogger(BaseDataObject.class.getName()).log(Level.SEVERE, null, ex);
                return new JSONArray();
            }
        } else {
            return new JSONArray();
        }
    }

}
