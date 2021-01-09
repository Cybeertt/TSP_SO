package com.company;

import java.util.ArrayList;

public class Solution {
    private ArrayList<Integer> travelling;
    private final Travelling path;
    private int numberOfIterations;
    private long timeDuration;

    public Solution(Travelling path, ArrayList<Integer> travelling) {
        this.path = path;
        this.travelling = travelling;
        this.numberOfIterations = 0;
        this.timeDuration = 0;
    }

    public void setTravelling(ArrayList<Integer> travelling) {
        this.travelling = travelling;
    }

    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    public long getTimeDuration() {
        return timeDuration;
    }

    public void setNumberOfIterations(int numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
    }

    public void setTimeDuration(long timeDuration) {
        this.timeDuration = timeDuration;
    }

    public ArrayList<Integer> getTravelling(){
        return new ArrayList<>(travelling);
    }

    public boolean addPath(Integer value){
        return travelling.add(value);
    }

    public int computeDistance(int []path, int ncities, int [][]cost) {
        int dist = 0;
        for(int i = 0; i < ncities-1; i++) {
            int curr = path[i] - 1;
            int next = path[i+1] - 1;
            dist += cost[curr][next];
        }

        int last = path[ncities-1] - 1;
        int first = path[0] - 1;
        dist += cost[last][first];
        return dist;
    }

}
