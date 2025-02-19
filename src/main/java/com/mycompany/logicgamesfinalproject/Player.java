/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

import java.util.ArrayList;

/**
 *
 * @author coope
 */
public class Player {
    private String name;
    private int[] gamesPlayed;
    private int[] gamesWon;
    private int gameState;
    public static final String[] gameList={"Mine Sweeper", "Memory", "Third"};
    
    public Player(String name){
        this.name=name;
        this.gameState=-1;
        
        
    }
    
    public void setGamesPlayed(int[] gamesPlayed){
        this.gamesPlayed=gamesPlayed;
    }
    public void setGamesWon(int[] gamesWon){
        this.gamesWon=gamesWon;
    }
    
    public int[] getGamesPlayed(){
        return this.gamesPlayed;
    }
    public int[] getGamesWon(){
        return this.gamesWon;
    }
    
    public String toString(int i){
        return gameList[i]+"|"+this.gamesPlayed[i]+"|"+this.gamesWon[i];
    }
    
}
