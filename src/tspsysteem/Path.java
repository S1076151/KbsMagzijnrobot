/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspsysteem;

import java.util.ArrayList;

public class Path {
    private ArrayList<Integer> moves;
    private Product fromProduct;
    private Product toProduct;
    
    public Path(ProductLine line){
        this.fromProduct = line.getFromProduct();
        this.toProduct = line.getToProduct();
       moves = new ArrayList<>();
    }

    public void addMove(int move) {
       this.moves.add(move);
    }

    @Override
    public String toString() {
        return "Path{" + "moves=" + moves + ", fromProduct=" + fromProduct.getId() + ", toProduct=" + toProduct.getId() + '}';
    }
    
    
    
    
    
    
    
    
    
    
}

