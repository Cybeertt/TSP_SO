package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import static com.company.Main.getMatrix;
import static com.company.Main.getNumOfCities;

public class Path {

    private int[] path;
    private Random rand = new Random();
    private int dist;

    public Path() {
        this.path = new int[getNumOfCities()];

        int count = 0;
        Arrays.fill(path, count + 1);

        random_path(path);
        this.dist = computeDistance(path, path.length, getMatrix());
    }

    public Path(int[] path) {
        this.path = path;
        this.dist = computeDistance(path, path.length, getMatrix());
    }

    public int[] getPath() {
        return path;
    }

    public void setPath(int[] path) {
        this.path = path;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public int computeDistance(int[] path, int numCities, int[][] cost) {
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
        int a = rand.nextInt() % path.length;
        int b = rand.nextInt() % path.length;
        int tmp = path[a];
        path[a] = path[b];
        path[b] = tmp;
    }

    public void invertPath(int[] path) {
        int a = rand.nextInt() % path.length;
        int b = rand.nextInt() % path.length;
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
        Arrays.fill(path, 0);
        for (int i=1; i <= path.length; i++) {
            int pos;
            do {
                pos = rand.nextInt(path.length) % path.length;
            } while (!(path[pos] == 0));
            path[pos] = i;
        }
    }

}
