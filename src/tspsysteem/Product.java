package tspsysteem;
public class Product {
    private int id;
    private int xPosition;
    private int yPosition;
    
    
    public Product(int id, int xPos, int yPos){
        this.id = id;
        this.xPosition = xPos;
        this.yPosition = yPos;
    }

    public int getId() {
        return id;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    @Override
    public String toString() {
        String newline = System.getProperty("line.separator");
        return "Product{" + "id=" + id + ", xPosition=" + xPosition + ", yPosition=" + yPosition + '}' + newline;
    }
    
    
    
    
}
