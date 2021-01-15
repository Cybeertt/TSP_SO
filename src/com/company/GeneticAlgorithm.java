package com.company;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class GeneticAlgorithm extends Thread {

    /*public static Semaphore search = new Semaphore(1);

    public static Semaphore update = new Semaphore(1);*/

    private final Travelling tsp;

    private final ArrayList<Integer> sortedPaths;
	
	private int populationSize;

    private double mutationRate;

    public static Solution lowerBound;

    private boolean work = true;

    public int rand = (int)Math.random();

    public GeneticAlgorithm(Travelling tsp, ArrayList<Integer> sortedPaths, int populationSize, double mutex) {
        this.tsp = tsp;
        this.sortedPaths = sortedPaths;
		this.populationSize = populationSize;
        this.mutationRate = mutex;
    }

    private Solution getSolution(ArrayList<Integer> lowerBound) {
        ArrayList<Integer> paths = new ArrayList<>(lowerBound);
        for(int i = 0; i< tsp.getNumCities() ; i++){
            /*tsp.distances = sortedPaths.get(i);
            int index = tsp.getDistances().indexOf();
            if(lowerBound.get(i) == 1){
                paths.set(index, 1);
            }else{
                paths.set(index, 0);
            }*/
        }
        Solution solution = new Solution(tsp);
        return solution;
    }

    private void geneticAlgorithm(Solution lowerBound) {

        long lStartTime = System.currentTimeMillis();
        long milisecons = 0;
        int iterations = 0;

        ArrayList<Integer> firstSolution = new ArrayList<>();

    }

    public void print_results(int iter_best, double time_best, int min_dist, int path[], int sz) {
        if (sz == 0) return;
        // numero de iteracoes|melhor tempo|distancia_minima|caminho
        System.out.printf("%d|%f|%d|", iter_best, time_best, min_dist);
        for (int i = 0; i < sz - 1; i++) {
            System.out.printf("%d,", path[i]);
        }
        System.out.printf("%d\n", path[sz - 1]);
    }

    public void doStop() {
        work = false;
    }
}
