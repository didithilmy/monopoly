/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.or.k4x2.monopoly.model;

import id.or.k4x2.monopoly.entity.Player;
import id.or.k4x2.monopoly.entity.Properties.Lot;
import id.or.k4x2.monopoly.entity.Property;
import id.or.k4x2.monopoly.entity.Tile;
import id.or.k4x2.monopoly.listeners.GameStateListener;
import id.or.k4x2.monopoly.listeners.Listeners;
import id.or.k4x2.monopoly.listeners.PlayerMovedListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
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
       } else {
           jailMap.put(player,turn+1); 
       }
    }
    
    public boolean checkJail(Player player){
        return (jailMap.containsKey(player)); 
    }
    
    
}
