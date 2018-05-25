/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Random;
import jenetic.interfaces.IPoint;

/**
 *
 * @author vieir
 */
public class Gene implements jenetic.interfaces.IGene, jenetic.interfaces.IPoint{

    private IPoint p;
    private Configuration c;

    
    public Gene(Point p, Configuration c) {
        this.p = p;
        this.c=c;
    }

    public Gene(Configuration c) {
        do{
        this.c = c;
        int minX = c.getStart().getX();
        int maxX = c.getEnd().getX();
        int minY = c.getStart().getY();
        int maxY = c.getEnd().getY();
        int x = minX + (maxX - minX) * new Random().nextInt();
        int y = minY + (maxY - minY) * new Random().nextInt();
      
        this.p = new Point(x, y);
        }while(!isValid());
        
    
        }
    
    @Override
    protected Object clone(){
        return new Gene((Point) this.p,c);
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

  
    @Override
    public boolean isValid() {
        return true;
       
    }

    public Point getP() {
        return (Point) p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    public Configuration getC() {
        return c;
    }

    public void setC(Configuration c) {
        this.c = c;
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
