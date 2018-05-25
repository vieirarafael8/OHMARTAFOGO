/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Rectangle;
import java.util.List;
import jenetic.interfaces.IPoint;

/**
 *
 * @author vieir
 */
public class Configuration implements jenetic.interfaces.IUIConfiguration {

    private int width;
    private int height;
    private List<Rectangle> obs;
    private IPoint pInit;
    private IPoint pFinal;

    public Configuration(int width, int height, List<Rectangle> obs, IPoint pInit, IPoint pFinal) {
        this.width = width;
        this.height = height;
        this.obs = obs;
        this.pInit = pInit;
        this.pFinal = pFinal;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public List<Rectangle> getObstacles() {
        return obs;
    }

    @Override
    public void setObstacles(List<Rectangle> list) {
        this.obs = list;
    }

    @Override
    public IPoint getStart() {
        return pInit;
    }

    @Override
    public void setStart(IPoint ipoint) {
        this.pInit = ipoint;
    }

    @Override
    public IPoint getEnd() {
        return pFinal;
    }

    @Override
    public void setEnd(IPoint ipoint) {
        this.pFinal = ipoint;
    }


    
}
