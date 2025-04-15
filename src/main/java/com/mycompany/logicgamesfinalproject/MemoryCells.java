/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

/**
 *
 * @author coope
 */
public class MemoryCells extends BoardCell{
    
    private MemoryCells[] selected= new MemoryCells[2];
    private int value;
    
    public MemoryCells(int x, int y){
        super(x, y);
        this.value=0;
        
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
        int valuesAssigned=0;
        int value=1;
        int checkVal=0;
        while(valuesAssigned<(gridSize*gridSize)){
            int row= (int) (Math.random()*cells.length);
            int col= (int) (Math.random()*cells.length);


            checkVal++;
            if(checkVal%3==0){
                checkVal=0;
                value++;
            }
            else{
                if(cells[row][col].getValue()==0){
                cells[row][col].setValue(value);
                valuesAssigned++;

               }
            }

        }
    }
}
