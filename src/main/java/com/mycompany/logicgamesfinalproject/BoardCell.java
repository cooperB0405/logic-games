/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

/**
 *
 * @author coope
 */
public class BoardCell {
    public int cellx;
    public int celly;
    public static int cellw=50;
    public static int cellh=50;
    private boolean isRevealed;
    public int value;
    
    public BoardCell(int x, int y){
        cellx=x;
        celly=y;
        isRevealed=false;
        value=1;
    }
    
    public boolean hasBeenRevealed(){
        return this.isRevealed;
    }
    public void revealCell(){
        this.isRevealed=true;
    }
    
    public static BoardCell[][] makeGrid(int gridSize){
        BoardCell[][] cells= new BoardCell[gridSize][gridSize];
        for(int i=0;i<gridSize; i++){
            for(int j=0; j<gridSize; j++){
                cells[i][j]=new BoardCell(50*i, 50*j);
            }
        }
        return cells;
    }
    

}
