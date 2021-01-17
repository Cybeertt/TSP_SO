package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Path {

    private int numCities;
    private int path[];
    private int matrix[][];
    private Random rand = new Random();


    public Path(int numCities) {
        this.numCities = numCities;
        this.path = new int[numCities];
        this.matrix = Population.matrix;

        int count = 0;
        for (int i = 0; i < numCities; i++) {
            path[i] = count+1;
        }
    }

    public void setNumCities(int numCities) {
        this.numCities = numCities;
    }

    public int getNumCities() {
        return numCities;
    }

    public int[] getPath() {
        return path;
    }

    public void setPath(int[] path) {
        this.path = path;
    }

    public int computeDistance(int[] path, int numCities, int cost[][]) {
        int dist = 0;
        for(int i = 0; i < numCities-1; i++) {
            int curr = path[i] - 1;
            int next = path[i+1] - 1;
            dist += cost[curr][next];
        }

        int last = path[numCities-1] - 1;
        int first = path[0] - 1;
        dist += cost[last][first];
        return dist;
    }

    public void mutatePath(int[] path) {
        int a = rand.nextInt() % numCities;
        int b = rand.nextInt() % numCities;
        int tmp = path[a];
        path[a] = path[b];
        path[b] = tmp;
    }

    public void invertPath(int[] path) {
        int a = rand.nextInt() % numCities;
        int b = rand.nextInt() % numCities;
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

    public void random_path(int[] path) {
        for (int i = 0; i < numCities; i++) {
            path[i] = 0;
        }
        for (int i=1; i <= numCities; i++) {
            int pos;
            do {
                pos = rand.nextInt() % numCities;
            } while (path[pos] != 0);
            path[pos] = i;
        }
    }

}
