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
        Layer l  = new Layer(250,250);
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("bicol.jpg"));
             l.addImage(img);
            img = ImageIO.read(new File("dory.jpg"));
             l.addImage(img);
            img = ImageIO.read(new File("palawan.jpg"));
             l.addImage(img);
            img = ImageIO.read(new File("whiteflower.jpg"));
            l.addImage(img);
            
            
            
        }catch(Exception e){
            
        }
        
        
        
    }
}