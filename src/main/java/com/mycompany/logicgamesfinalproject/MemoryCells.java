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
public class MemoryCells extends BoardCell{
    
    public static ArrayList<MemoryCells> selected =new ArrayList<>();
    private static int moves;
    
    public MemoryCells(int x, int y){
        super(x, y);
    }
    
    
    public static MemoryCells[][] makeGrid(int gridSize){
        MemoryCells[][] cells= new MemoryCells[gridSize][gridSize];
        for(int i=0;i<gridSize; i++){
            for(int j=0; j<gridSize; j++){
                cells[i][j]=new MemoryCells(50*i, 50*j);
            }
        }
        return cells;
    }


    public static void memoryCellValues(MemoryCells[][] cells, int gridSize){
        int[] numsToAssign = new int[gridSize*gridSize];
        int value=1;
        
        for(int i=0; i<numsToAssign.length;i+=2){
            numsToAssign[i]=value;
            numsToAssign[i+1]=value;
            value++;
        }
        for(int i=0; i<numsToAssign.length;i++){
            int row= (int) (Math.random()*cells.length);
            int col= (int) (Math.random()*cells.length);
            if(cells[row][col].getValue()==0){
                cells[row][col].setValue(numsToAssign[i]);

            }
            else{
                i=i-1;
            }
        }
    }
    
    public static boolean checkWin(MemoryCells[][] cells){
        boolean win=true;
        
        for(MemoryCells[] row: cells){
            for(MemoryCells cell: row){
                if(!cell.hasBeenRevealed()){
                    win=false;
                    break;
                }
            }
        }
        
        return win;
    }
    
    public static void setMoves(int movesToMake){
        moves=movesToMake;
    }
    public static int getMoves(){
        return moves;
    }
    
    public static void moveMade(){
        moves--;
    }
}
