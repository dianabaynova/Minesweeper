/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author diananb
 */
public class GameOverPanel {
   JFrame eFrame = new JFrame("Game over");
   JLabel textLabel1 = new JLabel();
   JLabel textLabel2 = new JLabel();
   JPanel textPanel1 = new JPanel();
   JPanel textPanel2 = new JPanel();
   JPanel buttonPanel = new JPanel();
   JButton plAgButton = new JButton();

   
   ///private int sizeLabel1 = 100;
   private int plAgButtonSize = 75;
   private int eFrameWidth = 600;
   private int eFrameLength = 800;
   
   GameOverPanel(int nSizeLabel, int nplAgButton)
   {
       eFrame.setVisible(true);
       eFrame.setSize(eFrameWidth, eFrameLength);
       eFrame.setLocationRelativeTo(null);
       eFrame.setResizable(false);
       eFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       eFrame.setLayout(new BorderLayout());

      textLabel1.setFont(new Font("Arial", Font.BOLD, 25));
      textLabel1.setHorizontalAlignment(JLabel.NORTH);
      textLabel1.setText("GAME OVER");
      textLabel1.setOpaque(true);
      
      textPanel1.setLayout(new BorderLayout());
      textPanel1.add(textLabel1);
      eFrame.add(textPanel1, BorderLayout.NORTH);
      
      textLabel2.setFont(new Font("Arial", Font.BOLD, 45));
      textLabel2.setHorizontalAlignment(JLabel.CENTER);
      textLabel2.setText("You won the game! Congrats!");//tuk trqbwa da ima if za win i lose text
      textLabel2.setOpaque(true);
      
      textPanel2.setLayout(new BorderLayout());
      textPanel2.add(textLabel2);
      eFrame.add(textPanel2, BorderLayout.CENTER);
      
      

   }
}
