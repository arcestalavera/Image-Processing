/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layer;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Jet
 */
public class Pipe {
    
    private ArrayList<Integer> list;
    public int greyValueSum;
    public int total;
    
    
    public Pipe(){
       greyValueSum = 0;
       total = 0;
       list= new ArrayList<>();
    }
    
    public void addColor(int rgb){
        list.add(rgb);
        Color c = new Color(rgb);
        greyValueSum +=  (c.getBlue() + c.getRed() + c.getGreen()) /3;
        total++;
    }
    
    
    public int getTop(){
        return list.get(list.size()-1);
    }
    
    public void whatami(){
        if(greyValueSum /total  > 127){
            //System.out.println("Queue "+ greyValueSum / total+"( "+ greyValueSum+ ")"+ total );
            //list.remove(0);
        }else{
            //System.out.println("Stack "+ greyValueSum / total+"( "+ greyValueSum+ ")"+ total);
        }
    }
    
    
    
    
    public int peel(){
        
        int pixel;
        
        if(greyValueSum/total > 127){
            pixel = list.get(0);
            list.remove(0);
        }else{
            pixel = list.get(list.size()-1);
            list.remove(list.size()-1);
        }
        return pixel;
    }
    
    
    
}
