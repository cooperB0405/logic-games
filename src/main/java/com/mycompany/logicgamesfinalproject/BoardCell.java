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
    public static int cellw=50;
    public static int cellh=50;
    public boolean showing;
    public int value;
    
    public BoardCell(int x, int y){
        cellx=x;
        celly=y;
        showing=false;
        value=1;
    }
}
