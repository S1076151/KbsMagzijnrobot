/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspsysteem;

import java.util.ArrayList;

/**
 *
 * @author Tyrone
 */
public class Route {
    private ArrayList<ProductLine> lines;

    public Route(ArrayList<ProductLine> lines) {
        this.lines = lines;
    }
    
    public Route(){
        this.lines = new ArrayList<>();
    }
    
    public void addLine(ProductLine line){
        lines.add(line);
    }

    public ArrayList<ProductLine> getLines() {
        return lines;
    }
    
    public int getMovesAmount(){
        int allMoves = 0;
        for (ProductLine line:lines){
            allMoves += line.getPath().getMoves().size();
        }
        
        return allMoves;
    }

    @Override
    public String toString() {
        return "Route{" + "lines=" + lines + '}';
    }
    
   
    
}
