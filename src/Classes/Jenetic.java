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
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.nonNull;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import jenetic.interfaces.IChromosome;
import jenetic.interfaces.IPoint;
import jenetic.interfaces.IUIConfiguration;




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
    private IUIConfiguration c;
    private int melhorSolu;
    private int tamHeredity;


    public Jenetic(int populationSize, int randomSize, int crossoverSize, int mutationSize, int maxIterations, double mutationFactor, IUIConfiguration c, int melhorSolu, int tamHeredity) {
        this.populationSize = populationSize;
        this.randomSize = randomSize;
        this.crossoverSize = crossoverSize;
        this.mutationSize = mutationSize;
        this.maxIterations = maxIterations;
        this.mutationFactor = mutationFactor;
        this.iteration = 0;
        this.historic=new ArrayList<>(populationSize);
        this.c =c;
        this.melhorSolu = melhorSolu;
        this.tamHeredity = tamHeredity;
        
        
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

    public IUIConfiguration getC() {
        return c;
    }

    public void setC(IUIConfiguration c) {
        this.c = c;
    }

    public int getMelhorSolu() {
        return melhorSolu;
    }

    public void setMelhorSolu(int melhorSolu) {
        this.melhorSolu = melhorSolu;
    }

    public int getTamHeredity() {
        return tamHeredity;
    }

    public void setTamHeredity(int tamHeredity) {
        this.tamHeredity = tamHeredity;
    }

  


    @Override
    public String toString() {
        return "Jenetic{" + "populationSize=" + populationSize + ", randomSize=" + randomSize + ", crossoverSize=" + crossoverSize + ", mutationSize=" + mutationSize + ", maxIterations=" + maxIterations + ", mutationFactor=" + mutationFactor + ", iteration=" + iteration + ", historic=" + historic + ", c=" + c + ", melhorSolu=" + melhorSolu + ", tamHeredity=" + tamHeredity + '}';
    }
    
   

    @Override
    public List<IChromosome> initialize() {
        return Stream.generate(() -> new Cromossoma(15, 2, c)).limit(populationSize).filter(Objects::nonNull).collect(Collectors.toList());
     
    }

    private IChromosome getRandomChromosome(List<IChromosome> parents)
    {
        return parents.get(new Random().nextInt(parents.size()));
    }
    @Override
    public List<IChromosome> cross(List<IChromosome> list) {
        return Stream.generate(() -> getRandomChromosome(list).cross(getRandomChromosome(list)))
                .limit(crossoverSize).filter(Objects::nonNull)
                .collect(Collectors.toList());

    }

    @Override
    public List<IChromosome> mutate(List<IChromosome> list) {
        return Stream.generate(() -> getRandomChromosome(list).mutate(mutationFactor))
                .limit(mutationSize).filter(Objects::nonNull)
                .collect(Collectors.toList());
        
    }

    @Override
    public List<IChromosome> heredity(List<IChromosome> list) {
       return Stream.generate(() -> getRandomChromosome(list).heredity())
                .limit(tamHeredity).filter(Objects::nonNull)
                .collect(Collectors.toList());

    }

    @Override
    public List<IChromosome> random() {
        return Stream.generate(() -> ((IChromosome) new Cromossoma(15,2, c)))
                        .limit(randomSize).filter(Objects::nonNull)
                        .collect(Collectors.toList());
        
    }

    @Override
    public List<IChromosome> selection(List<IChromosome> list) {
        return list.stream().sorted(Comparator.comparingDouble(IChromosome::getFitness))
                .limit(populationSize).filter(Objects::nonNull)
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
                                                .sorted((x, y)->Double.compare(x.getFitness(), y.getFitness()))
                                                .limit(melhorSolu).filter(Objects::nonNull)
                                                .collect(Collectors.toList());

            List<IChromosome> offspring = mutate(best);
            
            offspring.addAll(cross(best));
            offspring.addAll(heredity(best));
            offspring.addAll(random());
            
            best.addAll(offspring);
        
            population = selection(offspring);

            historic.add(population);
            
            IChromosome crmo = getFittest(population);
            System.out.println(crmo.getGenes().toString());
            
            pathV.paintPath(crmo.getGenes().stream().map(x -> (IPoint) x).collect(Collectors.toList()));
            pathV.setFitness(crmo.getFitness());
            pathV.setStringPath(crmo.toString());
            
            iteration++;
        } while (!canStop());
        
        IChromosome chromo = getFittest(population);
        System.out.println(chromo.toString());

        return iteration;
   
    }

 
    @Override
    public IChromosome getFittest(List<IChromosome> list) {
               return list.stream().sorted((x, y) -> Double.compare(x.getFitness(), y.getFitness())).limit(1).collect(Collectors.toList()).get(0);
 
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
