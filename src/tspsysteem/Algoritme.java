/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspsysteem;

import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public abstract class Algoritme {
    private String name;
    
    public Algoritme(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract Route calculateRoute();  
}
