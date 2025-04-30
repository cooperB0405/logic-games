/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.logicgamesfinalproject;

/**
 *
 * @author coope
 */
public interface Updatable {
    
    //interface methods
    public void update(boolean lose);
    
    public void update(int actionsLeft);
    
    public void update(boolean win, Player p, int gameNum);
    
    public void appendGameInfo(String text);
    
    public void flagPressed(boolean flag);
    
    public void cancelGame();

}
