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
public class ProductLine {
    
    private Product fromProduct;
    private Product toProduct;
    
    public ProductLine(Product fromProduct, Product toProduct){
        this.fromProduct = fromProduct;
        this.toProduct = toProduct;
    }

    public Product getFromProduct() {
        return fromProduct;
    }

    public Product getToProduct() {
        return toProduct;
    }
    
    
}
