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
    //mine sweeper fields
    private boolean isMine;
    private boolean isFlagged;
    private int adjMines;
    
    public static boolean lose;
    
    private static int numFlagsRemain;
    
    public static int numMinesInGrid;
    
    public MineSweeperCells(int x, int y){
        super(x, y);
        this.isMine=false;
        this.isFlagged=false;
        this.adjMines=0;
        this.lose=false;
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
    public void changeFlag(){
        if(this.isFlagged){
            this.cellUnFlagged();
        }
        else{this.cellFlagged();}
        this.isFlagged=!this.isFlagged;
    }
    
    
    
    //methods for flags
    public static void cellFlagged(){
        numFlagsRemain--;
    }
    public static void cellUnFlagged(){
        numFlagsRemain++;
    }
    public static void setNumFlags(int numFlags){
        numFlagsRemain=numFlags;
    }
    public static int getNumFlagsRemaining(){
        return numFlagsRemain;
    }
    
    //get and set adjacent mines
    public int getAdjMines(){
        return this.adjMines;
    }
    public void setAdjMines(int numAdjMines){
        this.adjMines=numAdjMines;
    }
    
    //make grid method
    public static MineSweeperCells[][] makeGrid(int gridSize){
        MineSweeperCells[][] cells= new MineSweeperCells[gridSize][gridSize];
        for(int i=0;i<gridSize; i++){
            for(int j=0; j<gridSize; j++){
                cells[i][j]=new MineSweeperCells(50*i, 50*j);
            }
        }
        return cells;
    }
    
    //method to place mines
    public static void placeMines(MineSweeperCells[][] cells, int numMines){
        numMinesInGrid=numMines;
        int minesPlaced=0;
        while(minesPlaced<numMines){
            //gets random cell
            int row= (int) (Math.random()*cells.length);
            int col= (int) (Math.random()*cells.length);
            //if cell isnt a mine, gets set to a mine
            if(!cells[row][col].isAMine()){
                cells[row][col].setMine(true);
                minesPlaced++;
            }
            
        }
    }
    
    //find and sets value for adjacent mines
    public static void findAdjMines(MineSweeperCells[][] cells){
        //list for directions
        int[] searchDirection= {-1, 0, 1};
        //loops through list
        for(int i=0; i<cells.length; i++){
            for(int j=0; j<cells[i].length; j++){
                //checks if not a mine
                if(!cells[i][j].isAMine()){
                    int adjCounter=0;
                    //chekcs near by cells
                    for(int changeX: searchDirection){
                        for(int changeY: searchDirection){
                            //gets new cordnet of nearby cells
                            int checkNewI = i+changeX;
                            int checkNewJ= j+changeY;
                            //checks all near by cells using direction list
                            if((checkNewI>=0 && checkNewI<cells.length)&&(checkNewJ>=0 && checkNewJ<cells[checkNewI].length)){
                                //checks new cell for mine
                                if(cells[checkNewI][checkNewJ].isMine){
                                    //adds to counter if it is a mine
                                    adjCounter++;
                                }
                            }
                        }
                    }
                    //sets cell's adjacent mines val
                    cells[i][j].setAdjMines(adjCounter);
                }
            }
        }
    }
    
    //check win method
    public static boolean checkWin(MineSweeperCells[][] cells, int mines){
        boolean win=false;
        int minesFlaggedCounter=0;
        
        //checks if all mines are flagged
        for(MineSweeperCells[] row: cells){
            for(MineSweeperCells cell: row){
                if(cell.isMine && cell.isFlagged){
                    minesFlaggedCounter++;
                }
            }
        }
        //returns true if all are flagged
        if(minesFlaggedCounter==mines){
            win=true;
        }
        
        return win;
    } 
}
