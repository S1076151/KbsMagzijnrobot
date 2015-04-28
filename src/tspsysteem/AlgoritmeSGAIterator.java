/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//SGAIT Warehouse(9,9)( = 10x10)
//500       5s
//1000      1m 8s


//SGAIT warehouse(99,99) ( = 100x100)

package tspsysteem;
import java.util.ArrayList;
import java.util.Iterator;


////
//
//  ALGORITME IS NIET BETER, TENMINSTE NIET tot en met 1000 producten ivm normale SGA
//
//
public class AlgoritmeSGAIterator extends Algoritme{
    private Locations positions;
    private ArrayList<ProductLine> allLines = new ArrayList<>();
    private ArrayList<Integer> productsDoneId = new ArrayList<>();
    private Route route= new Route();
    private ProductLine dummyProductLine;
    
    public AlgoritmeSGAIterator(String name, WareHouse magazijn,  Locations positions) {
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
            for (Iterator<ProductLine> line = allLines.iterator();line.hasNext();){
                ProductLine pl = line.next();
                if (pl.getFromProduct().getId() == fromProduct.getId() && !productsDoneId.contains(pl.getToProduct().getId())){
                    Path newPath = calculatePath(fromProduct,pl.getToProduct());
                    if (bestLine.getPath().getMoves().size() > newPath.getMoves().size()) {
                        bestLine = new ProductLine(fromProduct,pl.getToProduct(),newPath);
                    }
                    line.remove();
                }  
            }
            productsDoneId.add(bestLine.getFromProduct().getId());
            route.addLine(bestLine);
        }
        System.out.println(route.getMovesAmount());
        return route;
    }
}
