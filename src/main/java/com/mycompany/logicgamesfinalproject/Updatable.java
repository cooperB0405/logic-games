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
    
    public void update(boolean lose);
    
    public void update(int actionsLeft);
    
    public void update(boolean win, Player p, int gameNum);

}
