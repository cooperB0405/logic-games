/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    
    
    
    
    public static void getStats(Player player){
        
      
        BufferedReader inputStream = null;
        String[] gameStats= null;
        
        try{
            File file = new File("logicGames-"+player.getName()+".txt");
            if(!file.exists()){
                file.createNewFile();
            }
            inputStream = new BufferedReader(new FileReader(file));
            String l;
            int[] playedArr;
            int[] wonArr;
            l = inputStream.readLine();
            if(l==null){
                playedArr= new int[]{0, 0, 0};
                wonArr= new int[]{0, 0, 0};
            }
            else{
               
                gameStats=l.split("\\|");
                    
                
                
                inputStream.close();
                playedArr= new int[3];
                wonArr= new int[3];
                for(int i=0; i<gameStats.length; i++){
                    if(i<3){
                        playedArr[i]=Integer.parseInt(gameStats[i]);
                    }
                    else{
                        wonArr[i-3]=Integer.parseInt(gameStats[i]);
                    }
                }
            }
            for(int i=0; i<playedArr.length;i++){
                player.setGamesPlayed(playedArr[i], i);
                player.setGamesWon(wonArr[i], i);
            }

            player.saveStats();

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
