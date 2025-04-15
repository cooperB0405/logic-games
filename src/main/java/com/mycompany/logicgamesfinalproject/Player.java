/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author coope
 */
public class Player {
    private String name;
    private int[] gamesPlayed;
    private int[] gamesWon;

    public static final String[] gameList={"Mine Sweeper", "Memory", "Third"};
    
    public Player(String name){
        this.name=name;

        
        
    }
    
    public String getName(){
        return this.name;
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
    
    public void saveStats(){
        int[] played= this.gamesPlayed;
        int[] won = this.gamesWon;
        
        String dataToAdd="";
        for(int i=0; i<2; i++){
            if(i==0){
                dataToAdd= played[0]+"|"+played[1]+"|"+played[2]+"|";
            }
            else{
                dataToAdd=dataToAdd+won[0]+"|"+won[1]+"|"+won[2];
            }
        }
        
        try{
             BufferedWriter out= new BufferedWriter(new FileWriter("logicGames-"+this.name+".txt"));
             out.write(dataToAdd);
             out.close();
        }
        catch(Exception e){
            System.out.println("catch");
        }
        
        
        
                
    }
    
}
