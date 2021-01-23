package com.company;

import java.util.*;

public class Population {

    private ArrayList<Path> population;
    private ArrayList<Path> bestPaths;
    private double mutateChance;

    public Population() {
        this.population = new ArrayList<>();
        this.bestPaths = new ArrayList<>();
    }

    public Population(int numPath, double mutateChance) {
        this.population = new ArrayList<>();
        this.bestPaths = new ArrayList<>();
        this.mutateChance = mutateChance;
        createPaths(numPath);
        calcAllPathDist();
    }

    public ArrayList<Path> getPopulation() {
        return population;
    }

    public void setPopulation(ArrayList<Path> population) {
        this.population = population;
    }

    public void createPath() {
        Path path = new Path();
        population.add(path);
        sortPop();
    }

    public void createPaths(int numPaths) {
        for (int i = 0; i<numPaths; i++) {
            Path path = new Path();
            population.add(path);
        }
        sortPop();
    }

    public void sortPop() {
        population.sort(Comparator.comparingInt(Path::getDist));
    }

    public void deletePath(Path path) {
        population.remove(path);
    }

    public ArrayList<Path> getPaths() {
        ArrayList<Path> paths = new ArrayList<>();
        population.addAll(paths);
        return paths;
    }

    public void calcAllPathDist() {
        for (Path path: population
             ) {
            path.computeDistance();
        }
    }

    public Path getBestPath() {
        sortPop();
        return population.get(0);
    }

    public void best2Paths() {
        sortPop();
        bestPaths.clear();
        bestPaths.add(0, population.get(0));
        bestPaths.add(1, population.get(1));
    }

    public void deleteWorst2Paths() {
        sortPop();
        population.remove(population.size()-1);
        population.remove(population.size()-1);
    }

    public void pmxCrossover() {
        int n = Main.getNumOfCities();
        Random rand = new Random();
        int[] parent1 = bestPaths.get(0).getPath();
        int[] parent2 = bestPaths.get(1).getPath();
        int[] offSpring1 = new int[n];
        int[] offSpring2 = new int[n];

        int[] replacement1 = new int[n+1];
        int[] replacement2 = new int[n+1];
        int i, n1, m1, n2, m2;
        int swap;

        int cuttingPoint1 = rand.nextInt(n);
        int cuttingPoint2 = rand.nextInt(n);

        while (cuttingPoint1 == cuttingPoint2) {
            cuttingPoint2 = rand.nextInt(n);
        }

        if (cuttingPoint1 > cuttingPoint2) {
            swap = cuttingPoint1;
            cuttingPoint1 = cuttingPoint2;
            cuttingPoint2 = swap;
        }

        for (i=0; i < n+1; i++) {
            replacement1[i] = -1;
            replacement2[i] = -1;
        }

        for (i=cuttingPoint1; i <= cuttingPoint2; i++) {
            offSpring1[i] = parent2[i];
            offSpring2[i] = parent1[i];
            replacement1[parent2[i]] = parent1[i];
            replacement2[parent1[i]] = parent2[i];
        }

        // fill in remaining slots with replacements
        for (i = 0; i < n; i++) {
            if ((i < cuttingPoint1) || (i > cuttingPoint2)) {
                n1 = parent1[i];
                m1 = replacement1[n1];
                n2 = parent2[i];
                m2 = replacement2[n2];

                while (m1 != -1) {
                    n1 = m1; m1 = replacement1[m1];
                }
                while (m2 != -1) {
                    n2 = m2; m2 = replacement2[m2];
                }
                offSpring1[i] = n1;
                offSpring2[i] = n2;
            }
        }
        if (Math.random() < mutateChance) {
            mutatePath(offSpring1);
            mutatePath(offSpring2);
        }
        Path path1 = new Path(offSpring1);
        Path path2 = new Path(offSpring2);
        path1.computeDistance();
        path2.computeDistance();
        population.add(path1);
        population.add(path2);
    }

    public void mutatePath(int[] path) {
        Random rand = new Random();
        int a = rand.nextInt(path.length) % path.length;
        int b = rand.nextInt(path.length) % path.length;
        int tmp = path[a];
        path[a] = path[b];
        path[b] = tmp;
    }
}

