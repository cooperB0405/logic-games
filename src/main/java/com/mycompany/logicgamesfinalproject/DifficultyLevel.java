/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

/**
 *
 * @author coope
 */
public class DifficultyLevel extends javax.swing.JFrame {
    private int gameNum;
    private enum diff{EASY ,MEDIUM, HARD};
    diff difficulty;
    /**
     * Creates new form DifficultyLevel
     */
    public DifficultyLevel(int gameNum) {
        initComponents();
        this.gameNum=gameNum;
    }
    
    private void createGame(int game, diff difficulty){
        int gridSize=0;
        MineSweeperCells[][] msCells=null;
        MemoryCells[][] memCells=null;
        
        
        
        //alter game board
        if(game==1){
            Player.getPlayer("").setGamesPlayed(Player.getPlayer("").getGamesPlayed(0)+1, 0);
            Player.getPlayer("").saveStats();
            int numMines=0;
            if(difficulty==diff.EASY){
                gridSize=7;
                numMines=15;
            }
            else if(difficulty==diff.MEDIUM){
                gridSize=9;
                numMines=35;
            }
            else if(difficulty==diff.HARD){
                gridSize=12;
                numMines=55;
            }
            msCells= MineSweeperCells.makeGrid(gridSize);
            MineSweeperCells.placeMines(msCells, numMines);
            MineSweeperCells.findAdjMines(msCells);
        }
        else if(game==2){
            if(difficulty==diff.EASY){
                gridSize=4;
            }
            else if(difficulty==diff.MEDIUM){
                gridSize=5;
            }
            else if(difficulty==diff.HARD){
                gridSize=6;
            }
            memCells= MemoryCells.makeGrid(gridSize);
            MemoryCells.memoryCellValues(memCells, gridSize);
        }
        //use the math for the cells to figure out where the mouse is clickedd
        
        //create game win
        GameWin g= new GameWin(memCells, msCells);
        g.setVisible(true);
        
        if(game==2){
            g.hideFlagBtn();
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDifficulty = new javax.swing.JLabel();
        btnEasy = new javax.swing.JButton();
        btnMedium = new javax.swing.JButton();
        btnHard = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDifficulty.setText("Select Difficulty");

        btnEasy.setText("Easy");
        btnEasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEasyActionPerformed(evt);
            }
        });

        btnMedium.setText("Medium");
        btnMedium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMediumActionPerformed(evt);
            }
        });

        btnHard.setText("Hard");
        btnHard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDifficulty)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMedium)
                            .addComponent(btnEasy)
                            .addComponent(btnHard))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDifficulty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEasy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMedium)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHard)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEasyActionPerformed
        // TODO add your handling code here:
        difficulty=diff.EASY;
        createGame(gameNum, difficulty);
        this.setVisible(false);
    }//GEN-LAST:event_btnEasyActionPerformed

    private void btnMediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMediumActionPerformed
        // TODO add your handling code here:
        difficulty=diff.MEDIUM;
        createGame(gameNum, difficulty);
        this.setVisible(false);
    }//GEN-LAST:event_btnMediumActionPerformed

    private void btnHardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHardActionPerformed
        // TODO add your handling code here:
        difficulty=diff.HARD;
        createGame(gameNum, difficulty);
        this.setVisible(false);
    }//GEN-LAST:event_btnHardActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DifficultyLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DifficultyLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DifficultyLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DifficultyLevel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEasy;
    private javax.swing.JButton btnHard;
    private javax.swing.JButton btnMedium;
    private javax.swing.JLabel lblDifficulty;
    // End of variables declaration//GEN-END:variables
}
