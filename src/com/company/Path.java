package com.company;

import java.util.Arrays;
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

        random_path();
    }

    public Path(int[] path) {
        this.path = path;
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

    public void computeDistance() {
        int dist = 0;
        int numCities = getNumOfCities();
        int[][] cost = getMatrix();
        for(int i = 0; i < numCities-1; i++) {
            int curr = path[i] - 1;
            int next = path[i+1] - 1;
            dist += cost[curr][next];
        }

        int last = path[numCities-1] - 1;
        int first = path[0] - 1;
        dist += cost[last][first];
        setDist(dist);
    }

    public void mutatePath() {
        int a = rand.nextInt(path.length) % path.length;
        int b = rand.nextInt(path.length) % path.length;
        int tmp = path[a];
        path[a] = path[b];
        path[b] = tmp;
    }

    public void invertPath() {
        int a = rand.nextInt(path.length) % path.length;
        int b = rand.nextInt(path.length) % path.length;
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

    public void random_path() {
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
