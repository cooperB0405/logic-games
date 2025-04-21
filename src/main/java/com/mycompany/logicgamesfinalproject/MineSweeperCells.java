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
    public static void placeMines(MineSweeperCells[][] cells, int numMines){
        numMinesInGrid=numMines;
        int minesPlaced=0;
        while(minesPlaced<numMines){
            int row= (int) (Math.random()*cells.length);
            int col= (int) (Math.random()*cells.length);
            
            if(!cells[row][col].isAMine()){
                cells[row][col].setMine(true);
                minesPlaced++;
                System.out.println("mine placed");
            }
            
        }
    }
    
    public static void findAdjMines(MineSweeperCells[][] cells){
        int[] searchDirection= {-1, 0, 1};
        for(int i=0; i<cells.length; i++){
            for(int j=0; j<cells[i].length; j++){
                if(!cells[i][j].isAMine()){
                    int adjCounter=0;
                    for(int changeX: searchDirection){
                        for(int changeY: searchDirection){
                            int checkNewI = i+changeX;
                            int checkNewJ= j+changeY;
                            if((checkNewI>=0 && checkNewI<cells.length)&&(checkNewJ>=0 && checkNewJ<cells[checkNewI].length)){
                                if(cells[checkNewI][checkNewJ].isMine){
                                    adjCounter++;
                                    System.out.println("cell checked");
                                }
                            }
                        }
                    }
                    cells[i][j].setAdjMines(adjCounter);
                }
            }
        }
    }
    
    public static boolean checkWin(MineSweeperCells[][] cells, int mines){
        boolean win=false;
        int minesFlaggedCounter=0;
        
        
        for(MineSweeperCells[] row: cells){
            for(MineSweeperCells cell: row){
                if(cell.isMine && cell.isFlagged){
                    win=true;
                }
            }
        }
        
        return win;
    } 
}
