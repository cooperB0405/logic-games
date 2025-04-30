/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author coope
 */
public class MemoryCells extends BoardCell{
    //fields
    public static ArrayList<MemoryCells> selected =new ArrayList<>();
    private static int moves;
    private static boolean pokemon;
    private Image img;
    
    public MemoryCells(int x, int y){
        super(x, y);
    }
    
    //make grid method
    public static MemoryCells[][] makeGrid(int gridSize){
        MemoryCells[][] cells= new MemoryCells[gridSize][gridSize];
        //loops and adds cells to the grid
        for(int i=0;i<gridSize; i++){
            for(int j=0; j<gridSize; j++){
                cells[i][j]=new MemoryCells(BoardCell.cellw*i, BoardCell.cellh*j);
            }
        }
        return cells;
    }
    //set and get bool for pokemon field
    public static void setPoke(boolean pokeOn){
        pokemon=pokeOn;
    }
    public static boolean getPokemon(){
        return pokemon;
    }


    //method to set cell values and images
    public static void memoryCellValues(MemoryCells[][] cells, int gridSize, boolean pokemon) throws IOException{
        //makes lists of images and ints to assign to the cells
        Image[] imgToAssign = new Image[gridSize*gridSize];
        int[] numToAssign= new int[gridSize*gridSize];
        //lists for values and images needed
        Image[] imgList = new Image[(gridSize*gridSize)/2];
        int[] pokeDexUsed= new int[(gridSize*gridSize)/2];
        //assigns images
        for(int i=0; i<imgList.length; i++){
            if (pokemon){
                //gets a random num for pokemon
                boolean inList=false;
                int dexNum= (int) (Math.random()*1025);
                //checks if pokemon is already in list
                for(int val: pokeDexUsed){
                    if(val==dexNum){
                        inList=true;
                    }
                }
                //gets pic if not already used
                if(!inList){
                    try {
                        URL picLink= new URL("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+Integer.toString(dexNum)+".png");
                        
                        BufferedImage img= ImageIO.read(picLink);
                        
                        //scales image
                        imgList[i]= (Image)img;
                        imgList[i]= imgList[i].getScaledInstance(cellw-10, cellh-10, Image.SCALE_SMOOTH);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(MemoryCells.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
            //if not pokememory gets images from file
            else{
                try{
                    imgList[i]=  ImageIO.read(new File("src/main/images/MemoryImages/memory"+ (i+1) +".png"));
                }
                catch(Exception e){
                    System.out.println("image "+(i+1)+" didnt load");
                }
            }

            
        }
        int value=1;
        //loops to give images and values to the assigning list
        for(int i=0; i<imgToAssign.length;i+=2){
            imgToAssign[i]=imgList[i/2];
            imgToAssign[i+1]=imgList[i/2];
            numToAssign[i]=value;
            numToAssign[i+1]=value;
            value++;
        }
        //assigns cells values and images at random
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
    
    //method to check if won
    public static boolean checkWin(MemoryCells[][] cells){
        boolean win=true;
        //checks if all have been revealed
        for(MemoryCells[] row: cells){
            for(MemoryCells cell: row){
                if(!cell.hasBeenRevealed()){
                    //returns true if they have
                    win=false;
                    break;
                }
            }
        }
        
        return win;
    }
    
    
    //getters and setters for the cells
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
