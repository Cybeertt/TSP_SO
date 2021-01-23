package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static com.company.Main.getBestPath;
import static com.company.Main.setBestPath;

public class TSPThread extends Thread {
    private final int runningTime;
    private final int numPath;
    private final double mutateChance;

    public TSPThread(int runningTime, int numPath, double mutateChance) {
        this.runningTime = runningTime;
        this.numPath = numPath;
        this.mutateChance = mutateChance;
    }

    private synchronized void updatePath(Population pop) {
        if ((getBestPath() == null) || (getBestPath().getDist() > pop.getBestPath().getDist())) {
            setBestPath(pop.getBestPath());
        }
    }

    @Override
    public void run() {
        Population pop = new Population(numPath, mutateChance);
        pop.calcAllPathDist();

        LocalDateTime then = LocalDateTime.now();
        while (ChronoUnit.SECONDS.between(then, LocalDateTime.now()) < runningTime) {
            pop.best2Paths();
            pop.pmxCrossover();
            pop.deleteWorst2Paths();
        }
        System.out.println(currentThread().getName() + ": " + pop.getBestPath().getDist());
        updatePath(pop);
        interrupt();
    }
}