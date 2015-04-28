/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tspsysteem;


public class Settings {
    private Locations positions;
    private int setting = -1;
   
    
    public Settings(Locations positions) {
        this.positions = positions;
//        OpenDialoog moet hier bij in en harde setting er uit
        this.setting = 0;
        positions.setAmountProducts(15);
        positions.randomizePos();
    }

    public int getSetting() {
        return setting;
    }

    public void setSetting(int setting) {
        this.setting = setting;
    }
    
    
    
    
    


}
