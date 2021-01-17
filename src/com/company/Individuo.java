package com.company;

import java.util.Random;

public class Individuo {

    private int[] chrome;
    private double fit = -1;


    public Individuo(int[] chrome) {
        this.chrome = chrome;
    }


    public Individuo(int cLength) {

        int[] individual;
        individual = new int[cLength];

        for (int g = 0; g < cLength; g++) {
            individual[g] = g;
        }

        this.chrome = individual;
    }

    public int[] getChrom() {
        return this.chrome;
    }


    public int getChromLength() {
        return this.chrome.length;
    }

    public void setGene(int offset, int gene) {
        this.chrome[offset] = gene;
    }

    public int getGene(int offset) {
        return this.chrome[offset];
    }

    public void setFit(double fit) {
        this.fit = fit;
    }

    public double getFit() {
        return this.fit;
    }


    public String toString() {
        String output = "";
        for (int gene = 0; gene < this.chrome.length; gene++) {
            output += this.chrome[gene] + ",";
        }
        return output;
    }

    public boolean containsGene(int gene) {
        for (int i = 0; i < this.chrome.length; i++) {
            if (this.chrome[i] == gene) {
                return true;
            }
        }
        return false;
    }

}
