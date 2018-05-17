/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.List;
import jenetic.interfaces.IChromosome;

/**
 *
 * @author vieir
 */
public class Jenetic implements jenetic.interfaces.IJenetic{

    @Override
    public List<IChromosome> initialize() {
        return null;
        
    }

    @Override
    public List<IChromosome> cross(List<IChromosome> list) {
        return null;

    }

    @Override
    public List<IChromosome> mutate(List<IChromosome> list) {
        return null;
        
    }

    @Override
    public List<IChromosome> heredity(List<IChromosome> list) {
        return null;

    }

    @Override
    public List<IChromosome> random() {
        return null;
        
    }

    @Override
    public List<IChromosome> selection(List<IChromosome> list) {
        return null;
    
    }

    @Override
    public boolean canStop() {
        return true;
      
    }

    @Override
    public int run() {
        return 0;
   
    }

    @Override
    public IChromosome getFittest(List<IChromosome> list) {
        return null;
       
    }

    @Override
    public double getAverageFitness(List<IChromosome> list) {
        return 0;
       
    }

    @Override
    public IChromosome getBestSolution() {
        return null;
       
    }

    @Override
    public void writeResults() {
        System.out.println("x");
    }
    
}
