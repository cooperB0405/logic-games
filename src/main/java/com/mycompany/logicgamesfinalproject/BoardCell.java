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
    public int cellw;
    public int cellh;
    public boolean showing;
    public int value;
    
    public BoardCell(int x, int y, int w, int h){
        cellx=x;
        celly=y;
        cellw=w;
        cellh=h;
        showing=false;
        value=1;
    }
}
