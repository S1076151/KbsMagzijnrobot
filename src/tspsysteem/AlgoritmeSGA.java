/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//SGA Warehouse(9,9)( = 10x10)
//500       1s
//1000       12s


//SGA warehouse(99,99) ( = 100x100)
//500           2s
//1000          19s

package tspsysteem;
import java.util.ArrayList;

public class AlgoritmeSGA extends Algoritme{
    private Locations positions;
    private ArrayList<ProductLine> allLines = new ArrayList<>();
    private ArrayList<Integer> productsDoneId = new ArrayList<>();
    private Route route= new Route();
    private ProductLine dummyProductLine;
    
    public AlgoritmeSGA(String name, WareHouse magazijn,  Locations positions) {
        super(name,magazijn);
        this.positions = positions;
        Product dummyProduct = new Product(-2,super.getWareHouse().getxSize(),super.getWareHouse().getySize());
        dummyProductLine = new ProductLine(positions.getPositions().get(0),dummyProduct,calculatePath(positions.getPositions().get(0),dummyProduct));
    }
    @Override
    public Route calculateRoute() {
        for (Product p1:positions.getPositions()){
            for (Product p2: positions.getPositions()){
                if (!p1.equals(p2)){
                    allLines.add(new ProductLine(p1,p2, calculatePath(p1,p2)));
                }
            }
        }
        for (Product fromProduct:positions.getPositions()) {
            ProductLine bestLine = dummyProductLine;
            for (ProductLine line:allLines) {
                if (line.getFromProduct().getId() == fromProduct.getId() && !productsDoneId.contains(line.getToProduct().getId())){
                    Path newPath = calculatePath(fromProduct,line.getToProduct());
                    if (bestLine.getPath().getMoves().size() > newPath.getMoves().size()) {
                        bestLine = new ProductLine(fromProduct,line.getToProduct(),newPath);
                    }
                }   
            }
            productsDoneId.add(bestLine.getFromProduct().getId());
            route.addLine(bestLine);
        }
        System.out.println(route.getMovesAmount());
        return route;
    }
}
