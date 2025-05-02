/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

import java.awt.Color;

/**
 *
 * @author coope
 */
public class BoardCell {
    //basic variables for the cells
    public int cellx;
    public int celly;
    public static int cellw=50;
    public static int cellh=50;
    private boolean isRevealed;
    private int value;
    public Color color;
    private static final Color[] colors={Color.BLUE, Color.GREEN, Color.MAGENTA, 
                                    Color.YELLOW, Color.ORANGE, Color.RED, 
                                    Color.PINK, Color.cyan};
    
    public BoardCell(int x, int y){
        cellx=x;
        celly=y;
        isRevealed=false;
        value=0;
        int randomColor= (int) (Math.random()*colors.length);
        this.color=colors[randomColor];
        
    }
    
    //returns if cell is revealed
    public boolean hasBeenRevealed(){
        return this.isRevealed;
    }
    //reveals cell
    public void revealCell(){
        this.isRevealed=true;
    }
    //hids cell if it is revealed
    public void hideCell(){
        this.isRevealed=false;
    }
    //set and get value
    public void setValue(int val){
        this.value=val;
    }
    public int getValue(){
        return this.value;
    }
    
    //creates basic grid of BoardCells
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
