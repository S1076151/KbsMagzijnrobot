
package tspsysteem;

import java.util.ArrayList;
import java.util.Random;

public class Locations {
    private ArrayList<Product> positions;
    private int amountProducts;
    private WareHouse wareHouse;
    
    public Locations(WareHouse wareHouse){
        this.wareHouse = wareHouse;
        positions = new ArrayList<>();
    }

    public int getAmountProducts() {
        return amountProducts;
    }

    public ArrayList<Product> getPositions() {
        return positions;
    }
    
    public void setAmountProducts(int amountProducts) {
        this.amountProducts = amountProducts;
    }
    
    public void randomizePos(){
        positions.add(new Product(-1,0,0));
        Random rand = new Random();
        for (int i = 0; i < amountProducts; i++) {
        int x = rand.nextInt(wareHouse.getxSize()) + 0;
        int y = rand.nextInt(wareHouse.getySize()) + 0;
            positions.add(new Product(i, x,y));
        }
    }

    @Override
    public String toString() {
        return "Locations{" + "positions=" + positions + ", amountProducts=" + amountProducts + ", wareHouse=" + wareHouse + '}';
   
    }
    
                  
    
}
