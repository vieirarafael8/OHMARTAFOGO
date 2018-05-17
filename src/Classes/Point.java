/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author vieir
 */
public class Point implements jenetic.interfaces.IPoint{

    private int x;
    private int y;
    

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    

    @Override
    public int getX() {
        return x;
      
    }

    @Override
    public int getY() {
    return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
