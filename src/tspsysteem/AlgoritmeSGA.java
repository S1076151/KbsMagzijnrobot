/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspsysteem;

import java.util.ArrayList;

public class AlgoritmeSGA extends Algoritme{
    private final int up = 1;
    private final int right = 2;
    private final int down = 3;
    private final int left = 4;
    private final int pickUp  = 5;

    public AlgoritmeSGA(String name,  Locations positions) {
        super(name);
        
    }
    
    
    @Override
    public Route calculateRoute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Path calculatePath(Product fromProduct, Product toProduct) {
        Path path = new Path();
        int x1 = fromProduct.getxPosition();
        int y1 = fromProduct.getyPosition();
        int x2 = toProduct.getxPosition();
        int y2 = toProduct.getyPosition();
        while (x1 != x2) {
            if (x1 < x2) {
                path.addMove(up);
                x1 ++;
            }
            else if (x1 > x2){
                path.addMove(down);
                x1 --;
            }   
        }
                while (y1 != y2) {
            if (y1 < y2) {
                path.addMove(right);
                y1 ++;
            }
            else if (y1 > y2){
                path.addMove(left);
                y1 --;
            }   
        }
//          System.out.println(path.toString());
        
        return path;
    
    }
}
