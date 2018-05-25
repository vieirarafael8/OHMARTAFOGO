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

/**
 *
 * @author vieir
 */
public class Cromossoma implements jenetic.interfaces.IChromosome, Comparable<Cromossoma>{

    private int maxSize;
    private int minSize;
    private List<IGene> genes;
    private Configuration c;

    public Cromossoma(int maxSize, int minSize, Configuration c) {
        this.c =c;
        this.maxSize = maxSize;
        this.minSize = minSize;
        
        genes = new ArrayList<>();
        IPoint init = c.getStart();
        IPoint end = c.getEnd();
        IGene geneI = new Gene((Point) init, c);
        IGene geneale =new Gene(c);
        IGene geneF = new Gene((Point) end, c);
       
        genes.add(geneI);

        this.genes=XPath();
        
    }
    
    public List<IGene> XPath(){
        int pos=1;
        if(existeObstaculos(c.getStart(), c.getEnd())){
            int x = c.getStart().getX(), y= c.getStart().getY();
            A:
            do{
                Gene g = new Gene(c);
                genes.add(g);
                
                for(int j=pos; j<genes.size(); j++){
                    Gene gg = (Gene) genes.get(j);
                    if(existeObstaculos(new Point(x, y), new Point(gg.getX(), gg.getY()))){
                        genes.remove(genes.size()-1);
                        break;
                    }
                    pos++;
                    
                    x= gg.getX();
                    y=gg.getY();
                    
                    if(j==genes.size()-1 && !existeObstaculos(new Point(x, y), c.getEnd())){
                        genes.add(new Gene((Point) c.getEnd(), c));
                        break A;
                    }
                }
                
            }while(!genes.get(genes.size()-1).equals(c.getEnd()));
        }else{
            genes.add(new Gene((Point) c.getEnd(), c));
        }
        return genes;
    }
    

    public Cromossoma(Cromossoma other, List<IGene> genes, Configuration c) {
        this.maxSize = other.maxSize;
        this.minSize = other.minSize;
        this.genes = genes;
        this.c = c;
        this.genes = new ArrayList<>();
    }

   

    private Cromossoma(Cromossoma other, Configuration co) {
        this.maxSize=other.maxSize;
        this.minSize=other.minSize;
       this.genes = other.getGenes();
       this.c=co;
       
    }


    @Override
    public IChromosome mutate(double d) {
        
        List<IGene> newGenes = new ArrayList<>();
        
        int limit =0;
        int count=0;
        
        do{
            for(int i=1;i<genes.size()-1;i++){
                if(count<1){
                    IPoint p = ((Gene)this.genes.get(i)).getP();
                    double dif = (int) d * new Random().nextDouble();
                    if(new Random().nextDouble()>0.5){
                        dif *= -1;
                    }
                    int x = (int) (p.getX()+dif);
                    int y = (int) (p.getY()+dif);
                    IPoint newPoint = new Point(x, y);
                    Gene newGene = new Gene((Point) newPoint, c);
                    newGenes.add(newGene);
                    count++;
                }
            }
            
        }
        while(!isValid() && limit++ <30);
        
        return new Cromossoma(this,newGenes, c);
       
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
             IGene ge = new Gene( (Point) pm, c);
             newGenes.add(ge);
         } while(!isValid()&&limit++ <30); 
         
       }
        
        return new Cromossoma(this, newGenes, c);
 
    }

    @Override
    public IChromosome heredity() {
        return new Cromossoma(this, c);
   
    }

    @Override
    public List<IGene> getGenes() {
        return genes;
        
    }

    public void setGenes(List<IGene> genes) {
        this.genes = genes;
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
        if(!genes.stream().allMatch(x -> x.isValid())){
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
        return ic.getGenes().stream().map(x -> (Gene)x).allMatch(g -> g.getP().getX() >= -c.getWidth() & g.getP().getX() <= c.getWidth());
       
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
            int endX=end.getY();
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

    public Configuration getC() {
        
        return c;
    }

    public void setC(Configuration c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public int compareTo(Cromossoma t) {
       return Double.compare(this.getFitness(), t.getFitness());
      }
    
}
