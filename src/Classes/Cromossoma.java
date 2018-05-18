/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import jenetic.interfaces.IChromosome;
import jenetic.interfaces.IGene;

/**
 *
 * @author vieir
 */
public class Cromossoma implements jenetic.interfaces.IChromosome, Comparable<Cromossoma>{

    private int maxSize;
    private int minSize;
    private List<IGene> genes;
    private Configuration c;

    public Cromossoma(int maxSize, int minSize) {
        this.maxSize = maxSize;
        this.minSize = minSize;
      
        int size = new Random().nextInt(maxSize +1 - minSize) + minSize;
        genes = new ArrayList<>();
        for(int i=0; i<size; i++){
        genes.add(new Gene());
    
    }
    }

    public Cromossoma(Cromossoma other, IGene gene) {
        this.maxSize = maxSize;
        this.minSize = minSize;
        this.genes = other.getGenes();
    }

    private Cromossoma(Cromossoma aThis) {
        this.maxSize=aThis.maxSize;
        this.minSize=aThis.minSize;
       this.genes = aThis.getGenes();
    }
    
    
    
    
    @Override
    public IChromosome mutate(double d) {
        
        Gene gene = (Gene) ((Gene) this.genes.get(0)).clone();
        Cromossoma novo;
        int limit =0;
        
        do{
            double dif = (int) d *new Random().nextDouble();
            if(new Random().nextDouble() >0.5){
                dif *=-1;
            }
            int x = (int) (gene.getP().getX() + dif);
            int y = (int) (gene.getP().getY() +dif);
            Point p = new Point(x, y);
            gene.setP(p);
            novo = new Cromossoma(this, gene);
            
        }while(!isValid(novo) && limit++ <30);
        
        return novo;
       
    }

    @Override
    public IChromosome cross(IChromosome ic) {
        
        Gene gene = (Gene) ((Gene) this.genes.get(0)).clone();
        Cromossoma novo;
        int limit =0;
        
        do
        {
            gene.setP(((Gene)ic.getGenes().get(0)).getP());
            novo = new Cromossoma(this, gene);
        }while(!isValid(novo)&& limit++ <30);
        
        return novo;
 
    }

    @Override
    public IChromosome heredity() {
        return new Cromossoma(this);
   
    }

    @Override
    public List<IGene> getGenes() {
        return genes;
        
    }

    public void setGenes(List<IGene> genes) {
        this.genes = genes;
    }
    

    @Override
    public boolean isValid() {
        return genes.stream().map(x -> (Gene)x).allMatch(g -> (g.getP().getX() >= -c.getWidth()) & (g.getP().getX() <= c.getWidth()));
        
    }

    @Override
    public boolean isValid(IChromosome ic) {
        return ic.getGenes().stream().map(x -> (Gene)x).allMatch(g -> g.getP().getX() >= -c.getWidth() & g.getP().getX() <= c.getWidth());
       
    }

    @Override
    public double getFitness() {
        
        Gene g = (Gene) genes.get(0);
        Point p = g.getP();
        int initx = c.getStart().getX();
        int inity = c.getStart().getY();
        int finx = c.getEnd().getX();
        int finy = c.getEnd().getY();
        
        return ;
        
    }

    public int getMaxSize() {
        
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        
        this.maxSize = maxSize;
    }

    public int getMinSize() {
        
        return minSize;
    }

    public void setMinSize(int minSize) {
        
        this.minSize = minSize;
    }

    public Configuration getC() {
        
        return c;
    }

    public void setC(Configuration c) {
        this.c = c;
    }

    @Override
    public String toString() {
       return genes.get(0).toString();
        
    }


    @Override
    public int compareTo(Cromossoma t) {
       return Double.compare(this.getFitness(), t.getFitness());
      }
    
}
