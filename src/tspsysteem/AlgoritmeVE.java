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
public class AlgoritmeVE extends Algoritme {
    
    private Locations positions;
    private final int up = 1;
    private final int right = 2;
    private final int down = 3;
    private final int left = 4;
    private final int pickUp  = 5;
    private String[] lines;

    public AlgoritmeVE(String name, Locations positions){
        super(name);
        this.positions = positions;
        lines = new String[positions.getPositions().size()];
    }

    @Override
    public ArrayList<Integer> calculateRoute() {
       ArrayList<Path> allPaths = new ArrayList<>();
       for (Product p1: positions.getPositions()){
           for (Product p2: positions.getPositions()){
                   allPaths.add(CalculatePath(p1,p2));
           }
               
       }
       System.out.println(allPaths.toString());
       
       
       ArrayList<Integer> route = new ArrayList<>();
       return route;
    }
    
    private Path CalculatePath(Product fromProduct, Product toProduct) {
        ProductLine line = new ProductLine(fromProduct, toProduct);
        Path path = new Path(line);
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
          System.out.println(path.toString());
        return path;
    }
       
  
}
    
    
   
