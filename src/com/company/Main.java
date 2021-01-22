package com.company;

import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {

    private static final Scanner read = new Scanner(System.in);

    private static int numOfCities;
    private static int[][] matrix;

    public static int getNumOfCities() {
        return numOfCities;
    }

    public static int[][] getMatrix() {
        return matrix;
    }

    private static String filename;
    private static int numThreads;
    private static int runningTime;
    private static int numPath;
    private static double mutateChance;

    //private static ArrayList<Integer> dist;
    //private static final Path path = new Path(0, new int[]{1, 2, 3, 4, 5});

    private static int[][] distances;

    private static final Travelling tsp = new Travelling(0);

    public static void main(String[] args) throws IOException {
        //readTextFile();
        /*
        filename = args[1];
        numThreads = parseInt(args[2]);
        runningTime = parseInt(args[3]);
        numPath = parseInt(args[4]);
        mutateChance = parseDouble(args[5]);
        */

        filename = read.nextLine();
        runningTime = parseInt(read.nextLine());
        loadMatrix(filename);
        printMatrix(matrix);

        Population pop = new Population(5);


        LocalDateTime then = LocalDateTime.now();
        while (ChronoUnit.SECONDS.between(then, LocalDateTime.now()) < runningTime) {
            pop.best2Paths();
            pop.pmxCrossover();
            pop.deleteWorst2Paths();
        }
        pop.getPathDists();
    }


    public static int[][] loadMatrix(String filename) throws IOException  {
        BufferedReader buffer = new BufferedReader(new FileReader(filename));
        numOfCities = parseInt(buffer.readLine());
        matrix = new int[numOfCities][numOfCities];

        String line;
        int row = 0;
        while ((line = buffer.readLine()) != null) {
            String[] vals = line.trim().split("\\s+");

            int col = 0;
            for(String  c : vals)
            {
                matrix[row][col] = Integer.parseInt(c);
                col++;
            }
            row++;
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        StringBuilder str = new StringBuilder();
        int size = matrix.length;
        for (int[] ints : matrix) {
            for (int col = 0; col < size; col++) {
                str.append(String.format("%d ", ints[col]));
            }
            str.append("\n");
        }
        str.append("\n");
        System.out.println(str);
    }
}