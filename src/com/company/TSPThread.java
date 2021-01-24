package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.company.Main.*;

public class TSPThread extends Thread {
    private final int runningTime;
    private final int numPath;
    private final double mutateChance;
    private final Population population;

    public Population getPopulation() {
        return population;
    }

    public TSPThread(int runningTime, int numPath, double mutateChance) {
        this.runningTime = runningTime;
        this.numPath = numPath;
        this.mutateChance = mutateChance;
        population = new Population(numPath, mutateChance);
    }

    private synchronized void updatePath(Population pop) {
        if ((getBestPath() == null) || (getBestPath().getDist() > pop.getBestPath().getDist())) {
            setBestPath(pop.getBestPath());
        }
    }

    @Override
    public void run() {
        population.calcAllPathDist();

        LocalDateTime then = LocalDateTime.now();
        while (ChronoUnit.SECONDS.between(then, LocalDateTime.now()) < runningTime) {
            population.best2Paths();
            population.pmxCrossover();
            population.deleteWorst2Paths();
        }
        System.out.println(currentThread().getName() + ": " + population.getBestPath().getDist());
        updatePath(population);
        interrupt();
    }
}