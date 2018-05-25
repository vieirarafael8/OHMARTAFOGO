/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.Rectangle;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import jenetic.interfaces.IChromosome;
import jenetic.interfaces.IPoint;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;



/**
 *
 * @author vieir
 */
public class Jenetic implements jenetic.interfaces.IJenetic{

    
    private int populationSize;
    private int randomSize;
    private int crossoverSize;
    private int mutationSize;
    private int maxIterations;
    private double mutationFactor;
    private int iteration;
    private List<List<IChromosome>> historic;
    private List<Rectangle> rectangles;
    private Configuration c;
    private int melhorSolu;



    public Jenetic(int populationSize, int randomSize, int crossoverSize, int mutationSize, int maxIterations, double mutationFactor, List<Rectangle> rectangles, Configuration c, int melhorSolu) {
        this.populationSize = populationSize;
        this.randomSize = randomSize;
        this.crossoverSize = crossoverSize;
        this.mutationSize = mutationSize;
        this.maxIterations = maxIterations;
        this.mutationFactor = mutationFactor;
        this.iteration = 0;
        this.historic = new ArrayList<>(populationSize);
        this.rectangles = new ArrayList<>(rectangles);
        this.c=c;
        this.melhorSolu=melhorSolu;
    }

    public int getMelhorSolu() {
        return melhorSolu;
    }

    public void setMelhorSolu(int melhorSolu) {
        this.melhorSolu = melhorSolu;
    }


    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public int getRandomSize() {
        return randomSize;
    }

    public void setRandomSize(int randomSize) {
        this.randomSize = randomSize;
    }

    public int getCrossoverSize() {
        return crossoverSize;
    }

    public void setCrossoverSize(int crossoverSize) {
        this.crossoverSize = crossoverSize;
    }

    public int getMutationSize() {
        return mutationSize;
    }

    public void setMutationSize(int mutationSize) {
        this.mutationSize = mutationSize;
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public void setMaxIterations(int maxIterations) {
        this.maxIterations = maxIterations;
    }

    public double getMutationFactor() {
        return mutationFactor;
    }

    public void setMutationFactor(double mutationFactor) {
        this.mutationFactor = mutationFactor;
    }

    public int getIteration() {
        return iteration;
    }

    public void setIteration(int iteration) {
        this.iteration = iteration;
    }

    public List<List<IChromosome>> getHistoric() {
        return historic;
    }

    public void setHistoric(List<List<IChromosome>> historic) {
        this.historic = historic;
    }

    public List getRectangles() {
        return rectangles;
    }

    public void setRectangles(List rectangles) {
        this.rectangles = rectangles;
    }

    
    @Override
    public String toString() {
        return "Jenetic{" + "rectangles=" + rectangles + '}';
    }
    
    @Override
    public List<IChromosome> initialize() {
        return Stream.generate(() -> new Cromossoma(1, 1, c)).limit(populationSize).collect(Collectors.toList());
             
    }

    private IChromosome getRandomChromosome(List<IChromosome> parents)
    {
        return parents.get(new Random().nextInt(parents.size()));
    }
    @Override
    public List<IChromosome> cross(List<IChromosome> list) {
        return Stream.generate(() -> getRandomChromosome(list).cross(getRandomChromosome(list)))
                .limit(crossoverSize)
                .collect(Collectors.toList());

    }

    @Override
    public List<IChromosome> mutate(List<IChromosome> list) {
        return Stream.generate(() -> getRandomChromosome(list).mutate(1))
                .limit(mutationSize)
                .collect(Collectors.toList());
        
    }

    @Override
    public List<IChromosome> heredity(List<IChromosome> list) {
       throw new NotImplementedException();

    }

    @Override
    public List<IChromosome> random() {
        return Stream.generate(() -> ((IChromosome) new Cromossoma(1,1, c)))
                        .limit(randomSize)
                        .collect(Collectors.toList());
        
    }

    @Override
    public List<IChromosome> selection(List<IChromosome> list) {
        return list.stream().sorted((x, y)->Double.compare(y.getFitness(), x.getFitness()))
                                .limit(populationSize)
                                .collect(Collectors.toList());
    
    }

    @Override
    public boolean canStop() {
         return iteration >= maxIterations;
      
    }

    @Override
    public int run() {
        List<IChromosome> population = initialize();
        historic.add(population);

        iteration = 0;
        PathViewer pathV = new PathViewer(c);
        
        
        
        do
        {
            //aplica operadores apenas aos melhores
            List<IChromosome> best = population.stream()
                                                .sorted((x, y)->Double.compare(y.getFitness(), x.getFitness()))
                                                .limit(melhorSolu)
                                                .collect(Collectors.toList());

            List<IChromosome> offspring = mutate(best);
            offspring.addAll(cross(best));
            //offspring.addAll(heredity(best));
            offspring.addAll(random());

            best.addAll(offspring);

            System.out.println(best.size());

            population = offspring;

            historic.add(population);
            
            IChromosome chromo = getFittest(population);
            pathV.paintPath(chromo.getGenes().stream().map(x -> (IPoint) x).collect(Collectors.toList()));
            pathV.setFitness(chromo.getFitness());
            pathV.setStringPath(chromo.toString());
            
            iteration++;
        }while(!canStop());
        IChromosome chromo = getFittest(population);
        System.out.println(chromo.toString());

        return iteration;
   
    }

 
    @Override
    public IChromosome getFittest(List<IChromosome> list) {
               return list.stream().sorted((x,y)->Double.compare(y.getFitness(), x.getFitness())).findFirst().get();
  
       
    }

    @Override
    public double getAverageFitness(List<IChromosome> list) {
            return list.stream().mapToDouble(IChromosome::getFitness).average().getAsDouble();
  
       
    }

    @Override
    public IChromosome getBestSolution() {
                return historic.stream().map(x -> getFittest(x)).reduce((x,y) -> x.getFitness() > y.getFitness()? x : y).get();
   
       
    }

    @Override
    public void writeResults() {
        
        try
        {
            ArrayList<String> header = new ArrayList<>();
            header.add("Fitness");
            ArrayList<String> header2 = new ArrayList<>();
            header2.add("X");
            Files.deleteIfExists(Paths.get("fitnesses"));
            Files.deleteIfExists(Paths.get("avgFitnesses"));
            Files.deleteIfExists(Paths.get("coordinates"));
            Files.write(Paths.get("fitnesses"), header, StandardOpenOption.CREATE);
            Files.write(Paths.get("avgFitnesses"), header, StandardOpenOption.CREATE);
            Files.write(Paths.get("coordinates"), header2, StandardOpenOption.CREATE);
            Files.write(Paths.get("fitnesses"), historic.stream().map(x -> getFittest(x)).map(x -> x.getFitness()+"").collect(Collectors.toList()) , StandardOpenOption.APPEND);
            Files.write(Paths.get("avgFitnesses"), historic.stream().map(x -> getAverageFitness(x)).map(x -> x.toString()).collect(Collectors.toList()) , StandardOpenOption.APPEND);
            Files.write(Paths.get("coordinates"), historic.stream().map(x -> getFittest(x)).map(x -> x.getGenes().get(0).toString()).collect(Collectors.toList()) , StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
