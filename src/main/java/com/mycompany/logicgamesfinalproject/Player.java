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
import javax.swing.JOptionPane;

/**
 *
 * @author coope
 */
public class Player {
    public static Player p;
    //player attributes
    private String name;
    private int[] gamesPlayed;
    private int[] gamesWon;
    private int currentGame;
    //list of games that cant be changed 
    public static final String[] gameList={"Mine Sweeper", "Memory", "PokeMemory"};
    
    //private constructor for singleton
    private Player(){
        gamesPlayed=new int[gameList.length];
        gamesWon=new int[gameList.length];
    }
    
    //get Instance method for singleton
    public static Player getPlayer(){
        if(p==null){
            p= new Player();
        }
        return p;
    }
    
    //setter and getter method for game Number
    public void setCurrentGame(int gameNum){
        this.currentGame=gameNum;
    }
    public int getCurrentGame(){
        return this.currentGame;
    }
    //setter and getter for player name
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }
    //set games played and won
    public void setGamesPlayed(int gamesPlayed, int index){
        this.gamesPlayed[index]=gamesPlayed;
    }
    public void setGamesWon(int gamesWon, int index){
        this.gamesWon[index]=gamesWon;
    }
    //get games played and won
    public int getGamesPlayed(int index){
        return this.gamesPlayed[index];
    }
    public int getGamesWon(int index){
        return this.gamesWon[index];
    }
    //to string to get info
    public String toString(int i){
        return gameList[i]+"|"+this.gamesPlayed[i]+"|"+this.gamesWon[i];
    }
    
    //method to save stats to file
    public void saveStats(){
        //gets games won and played
        int[] played= this.gamesPlayed;
        int[] won = this.gamesWon;
        
        //prepares a string for wrighting to file
        String dataToAdd="";
        for(int i=0; i<gameList.length; i++){
            dataToAdd+=played[i]+"|"+won[i];
            if(i!=gameList.length-1){
                dataToAdd+="|";
            }
            
        }
        //write to file using players name
        try{
             BufferedWriter out= new BufferedWriter(new FileWriter("logicGames-"+this.name+".txt"));
             out.write(dataToAdd);
             out.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Unsuccessful Save", "Save Incomplete",JOptionPane.ERROR_MESSAGE);
        }
                
    }
    
    
    
    //get stats method
    public static void getStats(Player player){
        
      
        BufferedReader inputStream = null;
        String[] gameStats= null;
        
        try{
            //open file using player name
            File file = new File("logicGames-"+player.getName()+".txt");
            //checks if doent exist and creats a new file
            if(!file.exists()){
                file.createNewFile();
            }
            inputStream = new BufferedReader(new FileReader(file));
            String l;
            int[] playedArr;
            int[] wonArr;
            l = inputStream.readLine();
            //checks if file is null
            if(l==null){
                //if null sets all stats to 0
                playedArr= new int[]{0, 0, 0};
                wonArr= new int[]{0, 0, 0};
                
            }
            else{
               //split stats into array
                gameStats=l.split("\\|");
                    
                
                

                playedArr= new int[gameList.length];
                wonArr= new int[gameList.length];
                
                //load stats into arrays
                for(int i=0; i<gameList.length; i++){

                    playedArr[i]=Integer.parseInt(gameStats[(i*2)]);
                    wonArr[i]=Integer.parseInt(gameStats[((i*2)+1)]);
                    
                }
            }
            inputStream.close();
            //sets player fields
            for(int i=0; i<playedArr.length;i++){

                player.setGamesPlayed(playedArr[i], i);
                player.setGamesWon(wonArr[i], i);
            }
            //saves stats after loading
            player.saveStats();

        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
