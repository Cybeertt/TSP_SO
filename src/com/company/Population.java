package com.company;

import java.util.ArrayList;
import java.util.Vector;

public class Population {

    private ArrayList<Path> population;
    //private Vector<Vector<Double>> matrix = new Vector<Vector<Double>>();
    public static int matrix[][];
    private int numCities;

    public Population(int numCities) {
        this.population = new ArrayList<Path>();
        this.numCities = numCities;

        //Matrix de teste
        this.matrix = new int[][] {
                {0, 23, 10, 4, 1},
                {23, 0, 9, 5, 4},
                {10, 9, 0, 8, 2},
                {4, 5, 8, 0, 11},
                {1, 4, 2, 11, 0},
        };
    }

    public ArrayList<Path> getPopulation() {
        return population;
    }

    public void setPopulation(ArrayList<Path> population) {
        this.population = population;
    }

    /*
    public Vector<Vector<Double>> getMatrix() {
        return matrix;
    }

    public void setMatrix(Vector<Vector<Double>> matrix) {
        this.matrix = matrix;
    }
     */

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public void createPath() {
        Path path = new Path(numCities);
        population.add(path);
    }
}
