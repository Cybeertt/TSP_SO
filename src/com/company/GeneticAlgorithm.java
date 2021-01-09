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


    public void mutatePath(int[] path, int arr_sz) {
        int a = rand % arr_sz;
        int b = rand % arr_sz;
        int tmp = path[a];
        path[a] = path[b];
        path[b] = tmp;
    }

    public void invertPath(int[] path, int arr_sz) {

        int a = rand % arr_sz;
        int b = rand % arr_sz;
        if (a > b) {
            int aux = a;
            a = b;
            b = aux;
        }
        int i, j;
        for (i = a, j = b; i < j; i++, j--) {
            int tmp = path[i];
            path[i] = path[j];
            path[j] = tmp;
        }
    }

    public void random_path(int path[], int arr_sz) {
        for (int i = 0; i < arr_sz; i++) {
            path[i] = 0;
        }
        for (int i=1; i <= arr_sz; i++) {
            int pos;
            do {
                pos = rand % arr_sz;
            } while (path[pos] != 0);
            path[pos] = i;
        }
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
