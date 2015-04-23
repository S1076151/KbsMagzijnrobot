/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspsysteem;

import java.util.ArrayList;

public class Path {
    private ArrayList<Integer> moves = new ArrayList<>();
    
    public Path(){
    }

    public void addMove(int move) {
       this.moves.add(move);
    }

    public ArrayList<Integer> getMoves() {
        return moves;
    }
    

    @Override
    public String toString() {
        return "Path{" + "moves=" + moves + '}';
    }
    
    
    
    
    
    
    
    
    
    
}

