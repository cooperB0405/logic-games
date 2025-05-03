/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author coope
 */
public class GameBoardPanel extends javax.swing.JPanel{
    
    private MineSweeperCells[][] msCells;
    private MemoryCells[][] memCells;
    private boolean flagOn;
    //observer list 
    private ArrayList<Updatable> observerList= new ArrayList<>();
    private Image flag;
    private Image mine;

    /**
     * Creates new form GameBoard
     */
    public GameBoardPanel() {
        initComponents();
        flagOn=false;
        //load images
        
        try{
            flag = ImageIO.read(new File("src/main/images/mineFlag.gif"));
            mine= ImageIO.read(new File("src/main/images/bomb.png"));
        }
        catch(Exception e){
            flag=null;
            mine=null;
                    
        }
        
        
    }
    
    //adds observer to list
    public void addUpdatable(Updatable observer){
        observerList.add(observer);
    }
    
    //changes flag bool
    public void flagChange(){
        flagOn=!flagOn;
        //updates button on observer
        for(int i=0; i<observerList.size(); i++){
            observerList.get(i).flagPressed(flagOn);
        }
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2= (Graphics2D)g;
        
        //draws mine sweeper if the minesweeper grid is not null
        if(msCells!=null){
            //loops through grid
            for (int i=0; i<msCells.length; i++) {
                for(int j=0; j<msCells[i].length; j++){
                    //draw mine image 
                    if(msCells[i][j].isAMine()){
                        if(mine!=null){
                            g2.drawImage(mine, msCells[i][j].cellx+7, msCells[i][j].celly+10, this);
                        }
                        else{
                            g2.drawString("M", msCells[i][j].cellx+7, msCells[i][j].celly+10);
                        }
                    }


                    //else draws adjacent mine values
                    else{
                        g2.drawString(Integer.toString(msCells[i][j].getAdjMines()), 
                        msCells[i][j].cellx+(BoardCell.cellw/2)+5, msCells[i][j].celly+(BoardCell.cellh/2)+5);
                    }
                    
                    //covers cell info if it hasnt been revealed
                    if (msCells[i][j].hasBeenRevealed()==false){
                        
                        g2.setColor(msCells[i][j].color);
                        g2.fillRect(msCells[i][j].cellx, msCells[i][j].celly, BoardCell.cellw, BoardCell.cellh);
                        //draws flag if cell is flagged
                        if(msCells[i][j].hasBeenFlagged()){
                            if(flag!=null){
                                g2.drawImage(flag, msCells[i][j].cellx, msCells[i][j].celly, this);
                            }
                            else{
                                g2.drawString("Flag", msCells[i][j].cellx, msCells[i][j].celly);
                            }
                        }
                    }
                    //grid highlights
                    g2.setColor(Color.gray);
                    g2.drawRect(msCells[i][j].cellx, msCells[i][j].celly, BoardCell.cellw, BoardCell.cellh);
                    
                }

            }

        }
        //draws memory if grid is not null
        if(memCells!=null){
            //loop through grid
            for (int i=0; i<memCells.length; i++) {
                for(int j=0; j<memCells[i].length; j++){
                    //draws the image of the cell
                    g2.drawImage(memCells[i][j].getImage(), memCells[i][j].cellx+8, memCells[i][j].celly+10, this);
                    //covers the cell if it has not been revealed
                    if (!memCells[i][j].hasBeenRevealed()){
                        g2.setColor(memCells[i][j].color);
                        g2.fillRect(memCells[i][j].cellx, memCells[i][j].celly, BoardCell.cellw, BoardCell.cellh);
                    }
                    //grid highlights
                    g2.setColor(Color.gray);
                    g2.drawRect(memCells[i][j].cellx, memCells[i][j].celly, BoardCell.cellw, BoardCell.cellh);
                }

            }

        }

    }
    
    //method gets cells from game window
    public void getCells(MineSweeperCells[][] msCells, MemoryCells[][] memCells){
        this.msCells=msCells;
        this.memCells=memCells;
    }
    



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.MatteBorder(null));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //calls method on mouse Pressed
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        //gets mouse click and what cell was clicked
        int mouseX=evt.getX();
        int mouseY=evt.getY();
        double boardX=mouseX/BoardCell.cellw;
        double boardY=mouseY/BoardCell.cellh;
        boardX=Math.floor(boardX);
        boardY=Math.floor(boardY);
        //converts mouse click to place in the grid
        int arrayIndexX=(int)boardX;
        int arrayIndexY=(int)boardY;
        
        try{
            //logic for game
            //memory logic
            if (msCells==null && MemoryCells.getMoves()>0){
                //only select cells that are not revealed
                if(MemoryCells.selected.size()<2){
                    if(!memCells[arrayIndexX][arrayIndexY].hasBeenRevealed()){
                        memCells[arrayIndexX][arrayIndexY].revealCell();
                        MemoryCells.selected.add(memCells[arrayIndexX][arrayIndexY]);
                    }
                }
                //third cell in selected list
                //can pick a revealed cell only if
                //it is the cell in position 0 or 1 of selected list
                else{
                    if(memCells[arrayIndexX][arrayIndexY]==MemoryCells.selected.get(0)
                            ||memCells[arrayIndexX][arrayIndexY]==MemoryCells.selected.get(1)){
                        memCells[arrayIndexX][arrayIndexY].revealCell();
                        MemoryCells.selected.add(memCells[arrayIndexX][arrayIndexY]);
                    }
                    else if(!memCells[arrayIndexX][arrayIndexY].hasBeenRevealed()){
                        memCells[arrayIndexX][arrayIndexY].revealCell();
                        MemoryCells.selected.add(memCells[arrayIndexX][arrayIndexY]);
                    }
                }
                if(MemoryCells.selected.size()==3){
                    //hides cells first two cells if they do not match
                    if(MemoryCells.selected.get(0)!=MemoryCells.selected.get(1)){
                        MemoryCells.selected.get(0).hideCell();
                        MemoryCells.selected.get(1).hideCell();
                    }
                    //checks if third cell selected is cell 0 or 1
                    if(MemoryCells.selected.get(2)==MemoryCells.selected.get(0)
                            ||memCells[arrayIndexX][arrayIndexY]==MemoryCells.selected.get(1)){
                        //reveals the cell 
                        MemoryCells.selected.get(2).revealCell();
                    }
                    //removes cells 0 and 1 from the selected list
                    MemoryCells.selected.remove(1);
                    MemoryCells.selected.remove(0);
                }
                if(MemoryCells.selected.size()==2){
                    //checks if first two cells in list are not matching
                    if(MemoryCells.selected.get(0).getValue()!=MemoryCells.selected.get(1).getValue()){
                        repaint();
                        //decrements the move counter
                        MemoryCells.moveMade();
                        //notifies observer of move num changing
                        for(int i=0; i<observerList.size(); i++){
                            observerList.get(i).update(MemoryCells.getMoves());
                        }
                        //checks if out of moves
                        if(MemoryCells.getMoves()==0){
                            //you lose and notifies observer
                            JOptionPane.showMessageDialog(null, "You Ran Out Of Guesses", "You Lose",JOptionPane.ERROR_MESSAGE);
                            for(int i=0; i< observerList.size(); i++){
                                observerList.get(i).update(false);
                            }
                        }
                        else{
                            //sends message to text area
                            for(int i=0; i<observerList.size(); i++){
                                    observerList.get(i).appendGameInfo("Those Two Were Not A Match");
                                }
                            
                        }
                    }
                    else{
                        //removes values from the list
                        //keeps them revealed
                        MemoryCells.selected.remove(1);
                        MemoryCells.selected.remove(0);
                        //checks if you have won
                        if(MemoryCells.checkWin(memCells)){
                            repaint();
                            for(int i=0; i< observerList.size(); i++){
                                //checks for what memory game to give win stat to 
                                if(MemoryCells.getPokemon()){
                                    observerList.get(i).update(true, Player.getPlayer(), 2);
                                }
                                else{
                                    observerList.get(i).update(true, Player.getPlayer(), 1);
                                }

                            }

                        }
                    }                  
                }
            
            }
            else{
                if(!MineSweeperCells.lose ){
                    if(!flagOn && MineSweeperCells.getNumFlagsRemaining()!=0){
                        msCells[arrayIndexX][arrayIndexY].revealCell();
                        if(msCells[arrayIndexX][arrayIndexY].isAMine()){
                            MineSweeperCells.lose=true;
                            repaint();
                            JOptionPane.showMessageDialog(null, "You Clicked On A Mine", "You Lose",JOptionPane.ERROR_MESSAGE);
                            for(int i=0; i< observerList.size(); i++){
                                observerList.get(i).update(MineSweeperCells.lose);
                            }
                        }
                    }
                    else{
                        if(MineSweeperCells.getNumFlagsRemaining()== 0){
                            flagOn=true;
                            if(msCells[arrayIndexX][arrayIndexY].hasBeenFlagged()){
                                msCells[arrayIndexX][arrayIndexY].changeFlag();
                            }
                        }
                        else{msCells[arrayIndexX][arrayIndexY].changeFlag();}
                        //call check win and if false tell you have not flagged all mines
                        for(int i=0; i<observerList.size(); i++){
                            observerList.get(i).update(MineSweeperCells.getNumFlagsRemaining());
                        }
                        if(MineSweeperCells.getNumFlagsRemaining()==0){
                            repaint();
                            if(MineSweeperCells.checkWin(msCells, MineSweeperCells.numMinesInGrid)){
                                //post you won
                                repaint();
                                for(int i=0; i< observerList.size(); i++){
                                   observerList.get(i).update(true, Player.getPlayer(), 0);
                                }
                            }
                            else{
                                //edits text field
                                for(int i=0; i<observerList.size(); i++){
                                    observerList.get(i).appendGameInfo("All Mines Are Not Flagged, Unflag And Try Again");
                                }
                                
                                
                            }
                        }
                    }

                }
            }
        }
        catch(Exception e){
            //pop up if you clicked off of the game board
            JOptionPane.showMessageDialog(null, "Please Do Not Click Outside The Board", "Try Again",JOptionPane.ERROR_MESSAGE);
        }


        
        repaint();
        
        
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
