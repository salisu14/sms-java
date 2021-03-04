/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sulbasoft.utility;

/**
 *
 * @author M. S. Ali (CCS)
 */
public enum GenderType {
    MALE,
    FEMALE,
    OTHER;
    
    
    
    @Override
    public String toString() {
        String s = "";
        if(this.ordinal() == 0)
            s = "Male";
        if(this.ordinal() == 1)
            s = "Female";
        if(this.ordinal() == 2)
            s = "Other";
        return s;           
    }
}
