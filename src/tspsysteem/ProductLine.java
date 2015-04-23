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
    private Path path;
    
    public ProductLine(Product fromProduct, Product toProduct, Path path){
        this.fromProduct = fromProduct;
        this.toProduct = toProduct;
        this.path = path;
    }

    public Product getFromProduct() {
        return fromProduct;
    }

    public Product getToProduct() {
        return toProduct;
    }

    public Path getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "ProductLine{" + "fromProduct=" + fromProduct + ", toProduct=" + toProduct + '}';
    }
    
    
    
    
}
