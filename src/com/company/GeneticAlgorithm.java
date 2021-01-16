package com.company;

public class GeneticAlgorithm extends Thread {

    /*public static Semaphore search = new Semaphore(1);

    public static Semaphore update = new Semaphore(1);*/

    //private final Travelling tsp;

    //private final ArrayList<Integer> sortedPaths;
	
	private int populacaoSize;

    private double mutacaoRate;

    private double crossoverRate;

    private int elitismo;

    protected int tournamentSize;

    public GeneticAlgorithm(int populacaoSize, double mutacaoRate, double crossoverRate, int elitismo,
                            int tournamentSize) {
        this.populacaoSize = populacaoSize;
        this.mutacaoRate = mutacaoRate;
        this.crossoverRate = crossoverRate;
        this.elitismo = elitismo;
        this.tournamentSize = tournamentSize;
    }

    public Populacao initPopulation(int chromosomeLength){
        // Initialize population
        Populacao populacao = new Populacao(this.populacaoSize, chromosomeLength);
        return populacao;
    }

    public double calcFitness(Individuo individual, int num, int []path, int [][]dist){
        // Get fitness
        Path route = new Path(num, path);
        double fitness = 1 / route.computeDistance(path, num, dist);

        // Store fitness
        individual.setFit(fitness);

        return fitness;
    }

    public void evalPopulation(Populacao population, int num, int []path, int [][]dist){
        double populationFitness = 0;

        // Loop over population evaluating individuals and summing population fitness
        for (Individuo individual : population.getIndividuals()) {
            populationFitness += this.calcFitness(individual, num, path, dist);
        }

        double avgFitness = populationFitness / population.size();
        population.setPopulationFitness(avgFitness);
    }
}
