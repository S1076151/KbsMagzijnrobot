/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspsysteem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tyrone
 */
public class AlgoritmeVEv2 extends Algoritme {
    //-----uitvoering alleen par1
    //4: 24         0
    //5: 120        0    
    //6: 720        0
    //7: 5040       0
    //8: 40320      0
    //9: 362880     0
    //10: 3628800   1
    //11: 39916800  1
    private Locations positions;
    private ArrayList<Product> positions2;
    private final int up = 1;
    private final int right = 2;
    private final int down = 3;
    private final int left = 4;
    private final int pickUp  = 5;
    //private ArrayList<ArrayList<Product>> allRoutes;
    private ArrayList<ProductLine> allLines = new ArrayList<>();
    private Route bestRoute;
    //private int stopInt = 3628800;

    public AlgoritmeVEv2(String name, Locations positions){
        super(name);
        this.positions = positions;
        this.positions2 = positions.getPositions();
        
        bestRoute = new Route();
    }

    @Override
    public Route calculateRoute() {
        for (Product p1:positions.getPositions()){
            for (Product p2: positions.getPositions()){
                if (!p1.equals(p2)){
                    ProductLine line = new ProductLine(p1,p2, calculatePath(p1,p2));
                    allLines.add(line);
                }
            }
            
        }
        bestRoute= new Route(allLines);
        
        ArrayList<Product> products = new ArrayList<Product>(positions.getPositions());
        Product startProduct = new Product(-1,0,0);
        ArrayList<ProductLine> pl = new ArrayList<>();
        Route route = new Route(pl);
        calculatepart1(products,startProduct,route);
       
       
        System.out.println(bestRoute.toString());
        return bestRoute;
    }
    
    private void calculatepart1(ArrayList<Product> availableProducts, Product fromProduct, Route route){
        for (Product toProduct:availableProducts){
            Route routeClone = new Route(new ArrayList<>(route.getLines()));
            for (ProductLine line:allLines) {
                if (line.getFromProduct().getId() == fromProduct.getId() && line.getToProduct().getId() == toProduct.getId() ){
                    routeClone.addLine(line);
                }
            }
            if (availableProducts.size() > 1) {
                ArrayList<Product> availableProductsClone = new ArrayList<>(availableProducts);
                availableProductsClone.remove(toProduct);
                this.calculatepart1(availableProductsClone, toProduct, routeClone);
                availableProductsClone = null;
                routeClone = null;
            }
            else {
                if (bestRoute.getMovesAmount() > routeClone.getMovesAmount()){
                    bestRoute = routeClone;
                 }         
            }
        }
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
    
    
   
