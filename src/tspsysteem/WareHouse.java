package tspsysteem;
public class WareHouse {
    private int xSize;
    private int ySize;
    
    public WareHouse(int xSize, int ySize){
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        if (xSize > 0) {
            this.xSize = xSize;
        }
    }

    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        if (ySize > 0) {
            this.ySize = ySize;
        }
    }
    
}
