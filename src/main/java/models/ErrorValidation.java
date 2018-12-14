/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danko
 */
public class ErrorValidation {
    private List<String> message;

    public ErrorValidation() {
        message = new ArrayList<String>();
    }

    public ErrorValidation(ArrayList<String> message) {
        this.message = message;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
    
    public String getEnterMessage(int i) {
        return message.get(i);
    }

    public void addMessage(String text) {
        message.add(text);
    }
    
    
}
