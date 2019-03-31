/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.or.k4x2.monopoly.model;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.model.ContextEvents.GenericEvent;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Claudia Renata Maharani, NIM 18217048
 */
public class JailManager {
    private static JailManager instance = new JailManager();
    private Map<Player, Integer> jailMap;
    
    private JailManager(){
         jailMap = new HashMap<>(); 
    }
    
    public static JailManager getInstance(){
        return instance; 
    }
    
    //addTojail 
    //checkJail 
    //semua parameter player 
    //countJail 
    
    public void addJail(Player player){
        System.out.println("Player " + player.getDesignation() + " added to jail");
        jailMap.put(player, 0);
        GameManager.getInstance().movePlayer(player, 10, false);
    }
    
    public void removeJail(Player player){
        jailMap.remove(player); 
    }
    
    public void countTurn(Player player) {    
       int turn=jailMap.get(player); 
       if (turn==3){
           removeJail(player);
           Context.getInstance().logEvent(new GenericEvent(player.getName() + " dibebaskan dari Penjara karena sudah 3 giliran."));

       } else {
           jailMap.put(player,turn+1); 
       }
    }
    
    public boolean checkJail(Player player){
        return (jailMap.containsKey(player)); 
    }
    
    
}
