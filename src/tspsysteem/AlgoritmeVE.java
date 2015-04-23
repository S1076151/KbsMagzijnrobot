//WERKT NIET MEER!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
package tspsysteem;
import java.util.ArrayList;
import java.util.List;

public class AlgoritmeVE extends Algoritme {
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
    private ArrayList<ArrayList<Product>> allRoutes;
    private ArrayList<ProductLine> allLines = new ArrayList<>();
    private ArrayList<ArrayList<Route>> allPaths;
    private int stopInt = 3628800;
    private int garbage = 0;

    public AlgoritmeVE(String name, Locations positions){
        super(name);
        this.positions = positions;
        this.positions2 = positions.getPositions();
        allRoutes = new ArrayList<>();
    }

    @Override
    public ArrayList<Integer> calculateRoute() {

        ArrayList<Integer> intRoute = new ArrayList<>();
        ArrayList<Product> route = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<Product>(positions.getPositions());
        calculatepart1(products,route);
       
       
        System.out.println(allRoutes.size());
       return intRoute;
    }
    
    private void calculatepart1(ArrayList<Product> availableProducts, ArrayList<Product> route){
        for (Product product:availableProducts){
            if (availableProducts.size() > 1) {
            ArrayList<Product> availableProductsClone = new ArrayList<>(availableProducts);
            ArrayList<Product> routeClone = new ArrayList<>(route);
            availableProductsClone.remove(product);
            routeClone.add(product);
            this.calculatepart1(availableProductsClone, routeClone);
            availableProductsClone = null;
            routeClone = null;
            }
            else {
                route.add(product);
                allRoutes.add(route);

            }
        }
//        garbage++;
//        if (garbage > 20000000) {
//            garbage = 0;
//            System.gc();
//        }
    }        
    
    private Path calculatePath(Product fromProduct, Product toProduct) {
                Path path = new Path();
        ProductLine productLine = new ProductLine(fromProduct, toProduct, path);

        int x1 = productLine.getFromProduct().getxPosition();
        int y1 = productLine.getFromProduct().getyPosition();
        int x2 = productLine.getToProduct().getxPosition();
        int y2 = productLine.getToProduct().getyPosition();
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
    
    
   
