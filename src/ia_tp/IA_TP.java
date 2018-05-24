/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_tp;
import Classes.Configuration;
import Classes.Cromossoma;
import Classes.Gene;
import Classes.Jenetic;
import Classes.Point;
import interfacesGraficas.Inicial;
import java.util.List;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.swing.plaf.basic.BasicTextUI;
import jenetic.interfaces.IChromosome;
import jenetic.interfaces.IPoint;
import viewer.PathViewer;
/**
 *
 * @author vieir
 */
public class IA_TP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Inicial i = new Inicial();
        i.setVisible(true);
        i.setLocationRelativeTo(null);
        
        List<Rectangle> rr = new ArrayList<>();
        Rectangle r1 = new Rectangle(400,500,100,100);
        Rectangle r2 = new Rectangle(0,500,100,100);
        Point p1 = new Point(0, 0);
        Point p2 = new Point(500, 500);
        rr.add(r1);
        rr.add(r2);
      //  Gene g = new Gene(p1);
        Configuration c = new Configuration(500, 500, rr, p1, p2);
        PathViewer pp1 = new PathViewer(c);
        
        //Jenetic j = new Jenetic(100, 5, 5, 5, 5, 0.2, 100);
//        List<IChromosome> population = j.initialize();
//        IChromosome c1 = j.getFittest(population);
//        pp1.paintPath(c1.getGenes().stream().map(x -> (IPoint) x).collect(Collectors.toList()));
//        j.run();
        
        
    }
    
}
