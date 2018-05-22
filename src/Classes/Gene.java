/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Random;

/**
 *
 * @author vieir
 */
public class Gene implements jenetic.interfaces.IGene{

    private Point p;
    private Configuration c;

    
    public Gene(Point p) {
        this.p = p;
    }

    public Gene(Configuration c) {
        this.c = c;
        int minX = 0;
        int maxX = c.getWidth();
        int minY = 0;
        int maxY = c.getHeight();
        int x = minX + (maxX - minX) * new Random().nextInt();
        int y = minY + (maxY - minY) * new Random().nextInt();
        this.p = new Point(x, y);
        
    }

    Gene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Object clone(){
        return new Gene(this.p);
    }

    @Override
    public String toString() {
        return "Gene{" + "p=" + p + ", c=" + c + '}';
    }
    
    
    @Override
    public boolean isValid() {
        return true;
       
    }

    public Point getP() {
        return p;
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
    
    
}
