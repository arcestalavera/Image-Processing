/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image.processing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import layer.Layer;

public class ImageProcessing {
    public static void main(String[] args) {
       // new ImageView();
        Layer l  = new Layer(200,200);
        BufferedImage img = null;
        File outputfile = new File("saved.jpg");
   
        
        
        try{
            img = ImageIO.read(new File("pic1 (1).jpg"));
             l.addImage(img);
            img = ImageIO.read(new File("pic1 (2).jpg"));
             l.addImage(img);
            img = ImageIO.read(new File("pic1 (3).jpg"));
             l.addImage(img);
            img = ImageIO.read(new File("pic1 (4).jpg"));
            l.addImage(img);
            img = ImageIO.read(new File("pic1 (5).jpg"));
            l.addImage(img);
            
            img = ImageIO.read(new File("pic1 (6).jpg"));
            l.addImage(img);
            
            img = ImageIO.read(new File("pic1 (7).jpg"));
            l.addImage(img);
            img = ImageIO.read(new File("pic1 (8).jpg"));
            l.addImage(img);
            
            l.whou();
            
            ArrayList<BufferedImage> images = l.extract(7, 5);
           
            int num=0;
            for(BufferedImage img2: images){
                ImageIO.write(img2, "jpg", new File("saved "+num+".jpg"));
                num++;
            }
            
          
            
            
        }catch(Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            //System.out.println("Here");
        }
        
   
        
    }
}