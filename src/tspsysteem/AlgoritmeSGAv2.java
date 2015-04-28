/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//SGAv2 Warehouse(9,9)( = 10x10)
//1000         0s
//2000         1s
//3000         4s
//4000         8s
//5000         14s
//6000         18s
//6500         23s
//6600         30s
//6700         27s
//6800          27s
//6850          34s

//6900          1m 25s

//7000         1m 18s

//SGAv2 warehouse(99,99) ( = 100x100)
//1000         1s
//4000         16s

package tspsysteem;
import java.util.ArrayList;

public class AlgoritmeSGAv2 extends Algoritme{
    private Locations positions;
    private ArrayList<ProductLine> allLines = new ArrayList<>();
    private ArrayList<Integer> productsDoneId = new ArrayList<>();
    private Route route= new Route();
    private ProductLine dummyProductLine;
    private Integer allLinesIndex  = 0;
    
    public AlgoritmeSGAv2(String name, WareHouse magazijn,  Locations positions) {
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
        calculatePart1(positions.getPositions().get(0));
        System.out.println(route.getMovesAmount());
        return route;
    }
    
    private void calculatePart1(Product fromProduct){
        ProductLine bestLine = dummyProductLine;
        bestLine = calculatePart2(fromProduct, bestLine);
        productsDoneId.add(bestLine.getFromProduct().getId());
        route.addLine(bestLine);
        positions.getPositions().remove(fromProduct);
        try {
            calculatePart1(positions.getPositions().get(0));
        }catch (IndexOutOfBoundsException ex) {
            
        }
    }
    
    private ProductLine calculatePart2(Product fromProduct,ProductLine bestLine){
        try {
            ProductLine line = allLines.get(allLinesIndex);
            if (line.getFromProduct().getId() == fromProduct.getId() && !productsDoneId.contains(line.getToProduct().getId())){
                Path newPath = calculatePath(fromProduct,line.getToProduct());
                if (bestLine.getPath().getMoves().size() > newPath.getMoves().size()) {
                    bestLine = new ProductLine(fromProduct,line.getToProduct(),newPath);
                }
            }
            allLinesIndex++;
            calculatePart2(fromProduct,bestLine);
        } catch(IndexOutOfBoundsException ex) {
            return bestLine;
        }
        return bestLine;
    }
}
