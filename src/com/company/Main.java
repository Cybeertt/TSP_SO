package com.company;

import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Scanner read = new Scanner(System.in);

    private static int numOfCities;

    //private static ArrayList<Integer> dist;
    private static final Path path = new Path(0);

    //private Population population = new Population();

    private static int[][] distances;

    private static int[] dist;
    private static Random rand = new Random();


    private static final Travelling tsp = new Travelling(0);

    public static void main(String[] args) throws IOException {
        //readTextFile();

        String file;
        file = read.nextLine();
        load(file);



        int numcities = path.getNumCities();

        path.random_path(path.getPath(), numcities);

        path.mutatePath(path.getPath(), numcities);

        int cur_dist = path.computeDistance(path.getPath(), numcities, distances);

        System.out.println(cur_dist);

        //GeneticAlgorithm ga = new GeneticAlgorithm(numcities, 0.001, 0.9, 2, 5);

        //Populacao population = ga.initPopulation(size);

    }

    public static void load(String filename) throws IOException  {
        FileReader file;
        BufferedReader buffer;

        try {
            file = new FileReader(filename + ".txt");
            buffer = new BufferedReader(file);
            path.setNumCities(Integer.parseInt(buffer.readLine()));
            int n = path.getNumCities();

            dist = new int[n];
            distances = new int[n][n];
            //dist = new ArrayList<Integer>();
            //System.out.println(numcities);

            int row = 0;
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] tokenizer = line.trim().split(" +");

                for (int j = 0; j < tokenizer.length; j++) {
                    dist[j] = j+1;
                    distances[row][j] = Integer.parseInt(tokenizer[j]);
                }
                path.setPath(dist);

                row++;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String readTextFile() {
        String fileContent = "";
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("ex5.txt"));
            StringBuilder sb = new StringBuilder();
            String fileLine = "";
            while ((fileLine = br.readLine()) != null) {
                System.out.println(fileLine);
                sb.append(fileLine);
                sb.append(System.lineSeparator());
            }
            fileContent = sb.toString();
            br.close();
        } catch (IOException ioe) {
            ioe.getMessage();
        }
        return fileContent;
    }

}