/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspsysteem;


/**
 *
 * @author Tyrone
 */
public class AlgoritmeSSS extends Algoritme {
    private Locations positions;
    private Product[][] wareHouse;
    private Route route = new Route();
    
    public AlgoritmeSSS(String name, WareHouse wareHouse, Locations positions) {
        super(name, wareHouse);
        this.positions = positions;
    }

    @Override
    public Route calculateRoute() {
       wareHouse = new Product[super.getWareHouse().getxSize()][super.getWareHouse().getySize()];
       Product robot = new Product(-1,0,0);
       positions.getPositions().set(0, robot);
       for (Product product:positions.getPositions()){
           wareHouse[product.getxPosition()][product.getyPosition()] = product; // add object to that ArrayList
       }
       boolean right = true;
       Product prevProduct = robot;
        for (Product[] productArray:wareHouse){
            if (right) {
                for (int i = 0; i < productArray.length; i++){
                    if (productArray[i] != null) {
                        route.addLine(new ProductLine(prevProduct, productArray[i],calculatePath(prevProduct, productArray[i])));
                        prevProduct = productArray[i];
                    }
                }
                right = false;
            }
            else {
                for (int i = productArray.length -1; i > 0; i--){
                    if (productArray[i] != null) {
                        route.addLine(new ProductLine(prevProduct, productArray[i],calculatePath(prevProduct, productArray[i])));
                        prevProduct = productArray[i];
                    }
                }
                right = true;
            }
        }
        return route;
    }
}
