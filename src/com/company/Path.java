package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Path {

    private int numCities;

    private final ArrayList<Integer> paths;

    private ArrayList<Cidade> path = new ArrayList<>();

    private ArrayList<Cidade> pathanterior = new ArrayList<>();



    private double fitness = 0;
    private int distance = 0;

    public Path(int numCities) {
        this.numCities = numCities;
        this.paths = new ArrayList<>();
    }

    public ArrayList<Integer> getPaths() {
        return paths;
    }

    /*public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < getNumCities(); cityIndex++) {
            setCity(cityIndex, PathManager.getCity(cityIndex));
        }

        Collections.shuffle(path);
    }*/

    public void setNumCities(int numCities) {
        this.numCities = numCities;
    }

    public int getNumCities() {
        return numCities;
    }

    /*public void swapCities() {
        int a = generateRandomIndex();
        int b = generateRandomIndex();
        pathanterior = path;
        Cidade x = path.get(a);
        Cidade y = path.get(b);
        path.set(a, y);
        path.set(b, x);
    }

    public void revertSwap() {
        path = pathanterior;
    }

    private int generateRandomIndex() {
        return (int) (Math.random() * path.size());
    }

    public void setCity(int posicao, Cidade city) {
        path.set(posicao, city);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }

    public Cidade getCity(int index) {
        return (Cidade)path.get(index);
    }

    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }

    public int getDistance() {
        int distance = 0;
        for (int index = 0; index < path.size(); index++) {
            Cidade starting = getCity(index);
            Cidade destination;
            if (index + 1 < path.size()) {
                destination = getCity(index + 1);
            } else {
                destination = getCity(0);
            }
            distance += starting.distanceTo(destination);
        }
        return distance;
    }*/
}
