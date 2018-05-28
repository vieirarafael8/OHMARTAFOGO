/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import jenetic.interfaces.IChromosome;
import jenetic.interfaces.IGene;
import jenetic.interfaces.IPoint;
import jenetic.interfaces.IUIConfiguration;
import jenetic.interfaces.UIConfiguration;

/**
 *
 * @author vieir
 */
public final class Cromossoma implements jenetic.interfaces.IChromosome, Comparable<Cromossoma>{

    private int maxSize;
    private int minSize;
    private List<IGene> genes;
    private IUIConfiguration c;

    public Cromossoma(int maxSize, int minSize, IUIConfiguration c) {
        this.c =c;
        this.maxSize = maxSize;
        this.minSize = minSize;
        do{
        this.genes=XPath();
        }while(this.genes==null);
        System.out.println(genes.toString());
        System.out.println("ESTA NO CROMOSSOMA" +isValid());
        
    }
    
    public List<IGene> XPath(){
        List<IGene> pg = new ArrayList<>();
        Gene st = new Gene(c.getHeight(), c.getWidth());
        Gene fn = new Gene(c.getHeight(), c.getWidth());
        
        do{
        pg = new ArrayList<>();
        pg.add(st);
        boolean vl = false;
            do{
                vl=false;
                Gene g = new Gene(c.getHeight(), c.getWidth());
                Gene ug = (Gene) pg.get(pg.size()-1);
                if(!existeObstaculos(ug.getP(), g)){
                    pg.add(g);
                    if(!existeObstaculos(g.getP(), g)){
                        pg.add(fn);
                        vl=true;
                    }
                }
                
                }while(!vl);
        }while(pg.size()>this.maxSize);
        if(pg.size()<minSize){
            return null;
        }
        else{
            return pg;
        }
        
    }
    

    public Cromossoma(Cromossoma other, List<IGene> genes, IUIConfiguration c) {
        this.maxSize = other.maxSize;
        this.minSize = other.minSize;
        this.genes = genes;
        this.c = c;
        this.genes = new ArrayList<>();
    }

   

    private Cromossoma(Cromossoma other, IUIConfiguration co) {
        this.maxSize=other.maxSize;
        this.minSize=other.minSize;
       this.genes = other.getGenes();
       this.c=co;
       
    }


  @Override
    public IChromosome mutate(double d) {
        List<IGene> newGenes = new ArrayList<>();
        Gene start = new Gene(c.getStart().getY(), c.getStart().getX());
        Gene end = new Gene(c.getEnd().getY(), c.getEnd().getX());
        boolean valid = false;
        do {
            do {
                newGenes = new ArrayList<>();
                newGenes.add(start);
                valid = false;
                int cont = 1;
                for (int i = 1; i < genes.size() - 1; i++) {
                    valid = false;
                    IPoint p = ((Gene) this.genes.get(i)).getP();
                    double r = new Random().nextDouble();
                    double dif = d * r;
                    if (r > 0.5) {
                        dif *= -1;
                    }
                    int x = (int) ((int) p.getX() + dif);
                    int y = (int) ((int) p.getY() + dif);
                    IPoint newP = new Point(x, y);
                    Gene newG = new Gene(newP.getY(), newP.getX());
                    Gene lastGene = ((Gene) newGenes.get(cont - 1));
                    if (!existeObstaculos(lastGene.getP(), newG.getP())) {
                        newGenes.add(newG);
                        cont++;
                        if (!existeObstaculos(newG.getP(), end.getP())) {
                            newGenes.add(end);
                            valid = true;
                            cont++;
                        }
                    } else if (!existeObstaculos(lastGene.getP(), ((Gene) this.genes.get(i)).getP())) {
                        newGenes.add(((Gene) this.genes.get(i)));
                        cont++;
                        if (!existeObstaculos(newG.getP(), end.getP())) {
                            newGenes.add(end);
                            valid = true;
                            cont++;
                        }
                    }
                }
            } while (!valid);
        } while (newGenes.size() > this.maxSize);
        if (newGenes.size() < minSize) {
            return null;
        } else {
            return new Cromossoma(this, newGenes, c);
        }
    }

    @Override
    public IChromosome cross(IChromosome ic) {
        
       List<IGene> newGenes = new ArrayList<>();
       int limit=0;
       for(int i=0;i<genes.size()&&i<ic.getGenes().size(); i++){
         do{
             IPoint point =((Gene) this.genes.get(i)).getP();
             IPoint ip = ((Gene) ic.getGenes().get(i)).getP();
             int x = ((point.getX() + ip.getX())/2);
             int y = ((point.getY() + ip.getY())/2);
             IPoint pm = new Point(x, y);
             IGene ge = new Gene(c.getHeight(), c.getWidth());
             newGenes.add(ge);
         } while(!isValid()&&limit++ <30); 
         
       }
        
        return new Cromossoma(this, newGenes, c);
 
    }

    @Override
    public IChromosome heredity() {
        return new Cromossoma(this, c);
   
    }

  
    
    private boolean existeObstaculos(IPoint a, IPoint b){
        Iterator<Rectangle> ite = c.getObstacles().iterator();
        while(ite.hasNext()){
            Rectangle obstacle = ite.next();
            Line2D line = new Line2D.Float(a.getX(),a.getY(),b.getX(),b.getY());
            if(line.intersects(obstacle)){
                return true;
            }
    }
    return false;
    }    
    @Override
    public boolean isValid() {
        boolean estado = genes.stream().allMatch(x -> x.isValid());
        if(!estado){
            return false;
        }
        for(int i=0;i<genes.size()-1;i++){
            if(existeObstaculos((IPoint) genes.get(i), (IPoint) genes.get(i+1))){
              return false;  
            }
                
        }
        return true;
    }

    @Override
    public boolean isValid(IChromosome ic) {
        return ic.getGenes().stream().allMatch(x -> x.isValid());
       
    }

    @Override
    public double getFitness() {
        double fitness = 0;
        for(int i=0;i<genes.size();i++){
            Gene g = (Gene) genes.get(i);
            IPoint genePoint = g.getP();
            IPoint end = c.getEnd();
            
            int startX=genePoint.getX();
            int startY=genePoint.getY();
            int endX=end.getX();
            int endY=end.getY();
            double debaixoRaiz=(Math.pow((endX-startX),2) + Math.pow((endY-startY),2));
            fitness = fitness + Math.sqrt(debaixoRaiz);
        }
        return fitness;
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

    public List<IGene> getGenes() {
        return genes;
    }

    public void setGenes(List<IGene> genes) {
        this.genes = genes;
    }

    public IUIConfiguration getC() {
        return c;
    }

    public void setC(IUIConfiguration c) {
        this.c = c;
    }


   
    @Override
    public String toString() {
        return "Cromossoma{" + "maxSize=" + maxSize + ", minSize=" + minSize + ", genes=" + genes + ", c=" + c + '}';
    }


    @Override
    public int compareTo(Cromossoma t) {
       return Double.compare(this.getFitness(), t.getFitness());
      }
    
}
