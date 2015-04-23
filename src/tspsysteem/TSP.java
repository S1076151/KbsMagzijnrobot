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
public class TSP {
    private Algoritme algoritme;
    
    public TSP(){
        WareHouse wareHouse = new WareHouse(10,10);
        Locations positions = new Locations(wareHouse);
        Settings settings = new Settings(positions); //moet settings dialoog opene in constructor
        System.out.println(positions.toString());
        algoritme = new AlgoritmeVEv2("Ve", positions);
        switch (settings.getSetting()) {
                case 0: //VE
                        
                        break;
                case 1: //SGA
                        break;
                case 2: //S-Shape
                        break;
                default: //mag niet voorkomen
                        break;
        }
        algoritme.calculateRoute();
        
    }
    
}
