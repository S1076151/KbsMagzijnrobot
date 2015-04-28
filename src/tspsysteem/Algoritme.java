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
    private final int up = 1;
    private final int right = 2;
    private final int down = 3;
    private final int left = 4;
    private final int pickUp  = 5;
    private String name;
    private WareHouse wareHouse;
    
    public Algoritme(String name, WareHouse wareHouse){
        this.name = name;
        this.wareHouse = wareHouse;
    }

    public WareHouse getWareHouse() {
        return wareHouse;
    }
    
    

    public String getName() {
        return name;
    }
    public abstract Route calculateRoute();  
    
    protected Path calculatePath(Product fromProduct, Product toProduct) {
        Path path = new Path();
        int x1 = fromProduct.getxPosition();
        int y1 = fromProduct.getyPosition();
        int x2 = toProduct.getxPosition();
        int y2 = toProduct.getyPosition();
        while (x1 != x2) {
            if (x1 < x2) {
                path.addMove(right);
                x1 ++;
            }
            else if (x1 > x2){
                path.addMove(left);
                x1 --;
            }   
        }
                while (y1 != y2) {
            if (y1 < y2) {
                path.addMove(up);
                y1 ++;
            }
            else if (y1 > y2){
                path.addMove(down);
                y1 --;
            }   
        }
//          System.out.println(path.toString());
        
        return path;
    
    }
    
}
