/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author coope
 */
public class MemoryCells extends BoardCell{
    
    public static ArrayList<MemoryCells> selected =new ArrayList<>();
    private static int moves;
    
    private Image img;
    
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
        Image[] imgToAssign = new Image[gridSize*gridSize];
        int[] numToAssign= new int[gridSize*gridSize];
        Image[] imgList = new Image[(gridSize*gridSize)/2];
        for(int i=0; i<imgList.length; i++){
            try{
                imgList[i]=  ImageIO.read(new File("src/main/images/MemoryImages/memory"+ (i+1) +".png"));
            }
            catch(Exception e){
                System.out.println("image "+(i+1)+" didnt load");
            }
            
        }
        int value=1;
        
        for(int i=0; i<imgToAssign.length;i+=2){
            imgToAssign[i]=imgList[i/2];
            imgToAssign[i+1]=imgList[i/2];
            numToAssign[i]=value;
            numToAssign[i+1]=value;
            value++;
        }
        for(int i=0; i<imgToAssign.length;i++){
            int row= (int) (Math.random()*cells.length);
            int col= (int) (Math.random()*cells.length);
            if(cells[row][col].getValue()==0){
                cells[row][col].setImage(imgToAssign[i]);
                cells[row][col].setValue(numToAssign[i]);

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
    
    public void setImage(Image img){
        this.img=img;
    }
    public Image getImage(){
        return this.img;
    }
}
