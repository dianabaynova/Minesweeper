/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author diananb
 */
public class Minesweeper {
  JFrame frame = new JFrame("Minesweeper");
  JLabel textLabel = new JLabel();
  JPanel textPanel = new JPanel();
  JPanel boardPanel = new JPanel();
  
  private int tileSize;
  private int numRows; 
  private int bombs;
  private int numCols = numRows;
  private int boardWidth = numCols*tileSize;
  private int boardHeight = numRows*tileSize;
 
  public void setTileSize(int nTileSize)
  {
      tileSize = nTileSize;
  }
  public void setNumRows(int nNumRows)
  {
      numRows = nNumRows;
  }
  public void setBobmbs(int nBombs)
  {
      bombs = nBombs;
  }
  
  public Minesweeper(int nTileSize, int nNumRows, int nBombs)
  {
      frame.setVisible(true);
      frame.setSize(boardWidth, boardHeight);
      frame.setLocationRelativeTo(null);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLayout(new BorderLayout());
      
      textLabel.setFont(new Font("Arial", Font.BOLD, 25));
      textLabel.setHorizontalAlignment(JLabel.CENTER);
      textLabel.setText("Minesweeper");
      textLabel.setOpaque(true);
      
      textPanel.setLayout(new BorderLayout());
      textPanel.add(textLabel);
      frame.add(textPanel, BorderLayout.NORTH);
      
      boardPanel.setLayout(new GridLayout(numRows, numCols));
      boardPanel.setBackground(Color.gray);
      frame.add(boardPanel);
      
      
      
      
  }
    public static void board() {
        Scanner input= new Scanner(System.in);
        int[][] field = new int[9][9];
        Random xAxis = new Random();
        Random yAxis = new Random();
        for(int i=0; i<9; i++){
            for(int j=0; j<8; j++){
                field[i][j]=0;
            }
        }
        int mines=0;
        while(mines<=10){
            int x=xAxis.nextInt(9);
            int y=yAxis.nextInt(9);
            if(field[x][y]==0){
                field[x][y]=9;
                mines++;
            }
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(field[i][j]==0){
                    int counter = 0;
                    if(i>0)if(field[i-1][j]==9) counter++;
                    if(i<8)if(field[i+1][j]==9) counter++;
                    if(j>0)if(field[i][j-1]==9) counter++;
                    if(j<8)if(field[i][j+1]==9) counter++;
                    if(i>0 && j>0)if(field[i-1][j-1]==9) counter++;
                    if(i>0 && j<8)if(field[i-1][j+1]==9) counter++;
                    if(i<8 && j>0)if(field[i+1][j-1]==9) counter++;
                    if(i<8 && j<8)if(field[i+1][j+1]==9) counter++;
                    field[i][j]=counter;
                }
            }
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        int x = input.nextInt();
        int y = input.nextInt();
        rec(x, y, field);
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(field[i][j]==-1 || field[i][j]==-2)System.out.print(0 + " ");
                else System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void rec(int x, int y, int[][]field){
            if(field[x][y]!=-1 && field[x][y]!=9 && field[x][y]!=0){
                field[x][y]=-2;
                return;
            } 
            if(field[x][y]==0){
                field[x][y]=-1;
                if(x>0)rec(x-1, y, field);
                if(y>0)rec(x, y-1, field);
                if(x<8)rec(x+1, y, field);
                if(y<8)rec(x, y+1, field);
                if(y>0 && x>0) rec(x-1, y-1, field);
                if(y>0 && x<8) rec(x+1, y-1, field);
                if(y<8 && x>0) rec(x-1, y+1, field);
                if(y<8 && x<8) rec(x+1, y+1, field);
            }


    }
    
}
