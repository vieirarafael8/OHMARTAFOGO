    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Random;
import jenetic.interfaces.IPoint;
import jenetic.interfaces.IUIConfiguration;
import jenetic.interfaces.UIConfiguration;

/**
 *
 * @author vieir
 */
public class Gene implements jenetic.interfaces.IGene, jenetic.interfaces.IPoint{

    private IPoint p;
    private int height, width;

    
 

    public Gene(IPoint p, int height, int width) {
        this.p = p;
        this.height = height;
        this.width = width;
    }

    
    public Gene(int height, int width) {
        this.height = height;
        this.width = width;
  
        int x = new Random().nextInt(width);
        int y = new Random().nextInt(height);
      
        this.p = new Point(x, y);
        
        System.out.println(p.toString());
        
        
        }
    
    @Override
    protected Object clone(){
        return new Gene(this.p, this.height, this.width);
    }


    
    @Override
    public boolean isValid() {
      
       return (p.getX() >= 0 && p.getX() <= this.width && p.getY()>= 0 && p.getY()<=this.height);
    }

    public IPoint getP() {
        return p;
    }

    public void setP(IPoint p) {
        this.p = p;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

 

    @Override
    public int getX() {
        return p.getX();
    }

    @Override
    public int getY() {
        return p.getY();
    }
    
    
       
}
