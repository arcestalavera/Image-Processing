/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layer;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Jet
 */
public class Layer {

    public Pipe[][] pipes;
    private int width, height;

    public BufferedImage template = null;

    public Layer(int width, int height) {
        pipes = new Pipe[width][height];
        this.width = width;
        this.height = height;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pipes[y][x] = new Pipe();
            }
        }

    }

    public void restart() {
        pipes = new Pipe[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pipes[y][x] = new Pipe();
            }
        }
        
        int w = template.getWidth();
        int h = template.getHeight();
        Color c;
        //imagePixels = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                //System.out.println("x,y: " + i + ", " + j);
                int pixel = template.getRGB(i, j);
                c = new Color(pixel);
                if ((c.getRed() + c.getBlue() + c.getGreen()) / 3 > 127) {
                    pipes[j][i].setMode(true);
                } else {
                    pipes[j][i].setMode(false);
                }

                //imagePixels[i][j] = pixel;
            }
        }
        
        

    }

    public BufferedImage getImage() {
        int h = pipes.length;
        int w = pipes[0].length;

        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                //System.out.println("x,y: " + i + ", " + j);
                //int pixel = image.getRGB(i, j);
                img.setRGB(i, j, pipes[j][i].peel());

                //imagePixels[i][j] = pixel;
            }
        }
        return img;
    }

    public void PeelLayer() {

        int h = pipes.length;
        int w = pipes[0].length;

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                //System.out.println("x,y: " + i + ", " + j);
                //int pixel = image.getRGB(i, j);
                pipes[j][i].peel();
                //imagePixels[i][j] = pixel;

            }
        }
    }

    public ArrayList<BufferedImage> extract(int k, int m) {

        int h = pipes.length;
        int w = pipes[0].length;
        int pixel;
        ArrayList<BufferedImage> image_list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            image_list.add(getImage());
        }

        return image_list;
    }

    public void whou() {

        int h = pipes.length;
        int w = pipes[0].length;

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                //System.out.println("x,y: " + i + ", " + j);
                //int pixel = image.getRGB(i, j);
                //System.out.println("j "+j+" : "+i);
                pipes[j][i].whatami();
                //imagePixels[i][j] = pixel;

            }
        }
    }

    public void addTemplate(BufferedImage image) {

        int w = image.getWidth();
        int h = image.getHeight();
        Color c;
        //imagePixels = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                //System.out.println("x,y: " + i + ", " + j);
                int pixel = image.getRGB(i, j);
                c = new Color(pixel);
                if ((c.getRed() + c.getBlue() + c.getGreen()) / 3 > 127) {
                    pipes[j][i].setMode(true);
                } else {
                    pipes[j][i].setMode(false);
                }

                //imagePixels[i][j] = pixel;
            }
        }

    }

    public void addImage(BufferedImage image) {

        int w = image.getWidth();
        int h = image.getHeight();

        //imagePixels = new int[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                //System.out.println("x,y: " + i + ", " + j);
                int pixel = image.getRGB(i, j);
                pipes[j][i].addColor(pixel);
                //imagePixels[i][j] = pixel;

            }
        }

    }

    public int getPileSize() {
        return pipes.length;
    }

}
