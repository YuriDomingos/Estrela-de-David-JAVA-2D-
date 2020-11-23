
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author : Yuri DOmingos ( Labareda )
 * Data    : 20 - 11 - 2020
 * Objectivo  : Fazer a estrela de davi ( com o GeneralPath ) e fazer a mesma girar . 
 */
public class Estrela extends JPanel implements Runnable {

   
    private Point2D[] point, point2;
    private int angle1;
    private int counter = 1;

    public Estrela() {
        
       //  primeiro vetor
       point = new Point2D[3];
       
       point[0] = new Point2D.Double(80f,100f); 
       point[1] = new Point2D.Double(400f,100f);
       point[2] = new Point2D.Double(240f,-190f);
       
       
       // Segundo vetor
       
       point2 = new Point2D[3];
       
       point2[0] = new Point2D.Double(80f,-90f);
       point2[1] = new Point2D.Double(240f, 190f);
       point2[2] = new Point2D.Double(400f, -90f);
       
        
        new Thread(this).start();
        
    }
    
    
    /*
      Para Evitar repitir passos
    */
    
    public void recursive(GeneralPath path, Point2D point [], int counter)
    {
        if ( counter < point.length )
        {
           path.lineTo((float)point[counter].getX(), (float)point[counter].getY());
           
           recursive(path,point, counter+1);
        }
        
    }
    
    
    
    public void paintComponent(Graphics g)
    {
        
        super.paintComponent(g);
        
        Graphics2D graphics2D = (Graphics2D)g.create();
        
        this.setBackground(Color.WHITE);
        
        GeneralPath path = new GeneralPath();
        
        graphics2D.setStroke(new BasicStroke(5f));
        
        graphics2D.setPaint(Color.BLACK);
       
        graphics2D.setFont(new Font("Serif", Font.BOLD,15));
        graphics2D.drawString(" Estrela de Davi ( by : Labareda )", 110,100);
       
        graphics2D.setColor(Color.blue);
        
        graphics2D.rotate(Math.toRadians(angle1++), this.getWidth()/2, this.getHeight()/2);
        
        graphics2D.translate(this.getWidth()/2-200, this.getHeight()/2);
         
        path.moveTo(point[0].getX(), point[0].getY());
        recursive(path,point,counter);
        path.closePath();
        graphics2D.draw(path);
        
        
        //--- desenhar o segundo  tringle
        
        path.moveTo(point2[0].getX(), point2[0].getY());
        recursive(path,point2,counter);
        path.closePath();
        graphics2D.draw(path);
        
        
        
       
     
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void run() {
        
        while(true)
        {
            
            repaint();
            
            try {
                Thread.sleep(100);
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Estrela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
 
    
}
