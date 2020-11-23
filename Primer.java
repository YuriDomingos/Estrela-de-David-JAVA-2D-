
import java.awt.Color;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yuri Domingos
 Data : 18 - 11 -2020
 Objectivo : Desenhar a estrela de Davi ( a estrela da bandeira de israel )
 */
public class Primer.java{
    
    public static void main(String[] args) {
        
        
        JFrame frame = new JFrame("Estrela de dav");
        
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.red);
        frame.getContentPane().add(new Estrela());
        frame.setVisible(true);
    }
    
}
