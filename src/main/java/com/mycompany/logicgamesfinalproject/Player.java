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
    public static Player p;
    
    private String name;
    private int[] gamesPlayed;
    private int[] gamesWon;

    public static final String[] gameList={"Mine Sweeper", "Memory", "Third"};
    
    private Player(String name){
        this.name=name;
        gamesPlayed=new int[gameList.length];
        gamesWon=new int[gameList.length];
    }
    
    public static Player getPlayer(String name){
        if(p==null){
            p= new Player(name);
        }
        return p;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setGamesPlayed(int gamesPlayed, int index){
        this.gamesPlayed[index]=gamesPlayed;
    }
    public void setGamesWon(int gamesWon, int index){
        this.gamesWon[index]=gamesWon;
    }
    
    public int getGamesPlayed(int index){
        return this.gamesPlayed[index];
    }
    public int getGamesWon(int index){
        return this.gamesWon[index];
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
