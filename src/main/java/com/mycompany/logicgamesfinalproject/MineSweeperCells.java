/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

/**
 *
 * @author coope
 */
public class MineSweeperCells extends BoardCell{
    
    private boolean isMine;
    private boolean isFlagged;
    private int adjMines;
    
    public MineSweeperCells(int x, int y){
        super(x, y);
        this.isMine=false;
        this.isFlagged=false;
        this.adjMines=0;
    }
    
    
    
    //get and set methods
    public boolean isAMine(){
        return isMine;
    }
    public void setMine(boolean settingTheMine){
        this.isMine=settingTheMine;
    }
    

    
    public boolean hasBeenFlagged(){
        return this.isFlagged;
    }
    public void flag(){
        this.isFlagged=true;
    }
    
    public int getAdjMines(){
        return this.adjMines;
    }
    public void setAdjMines(int numAdjMines){
        this.adjMines=numAdjMines;
    }
    
    
    public static MineSweeperCells[][] makeGrid(int gridSize){
        MineSweeperCells[][] cells= new MineSweeperCells[gridSize][gridSize];
        for(int i=0;i<gridSize; i++){
            for(int j=0; j<gridSize; j++){
                cells[i][j]=new MineSweeperCells(50*i, 50*j);
            }
        }
        return cells;
    }
}
