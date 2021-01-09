package com.company;

import java.util.*;

public class Travelling {

    private int numCities;

    private int[][] distances;

    public Travelling(int numCities) {
        this.numCities = numCities;
        distances = new int[numCities][numCities];
    }

    public void setDistances(int[][] distances) {
        this.distances = distances;
    }

    public int[][] getDistances() {
        return distances;
    }

    public void setNumCities(int numCities) {
        this.numCities = numCities;
    }

    public int getNumCities() {
        return numCities;
    }

    public void printTravelPath(){
        System.out.println("\n*** Distancias ***");
        System.out.printf("Numero de cidades: %d \n", numCities);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Travelling other = (Travelling) obj;
        return (this.numCities == other.numCities) && (Objects.equals(this.distances, other.distances));
    }

}
