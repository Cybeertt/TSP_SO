package com.company;

import java.io.*;
import java.util.Arrays;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Main {
    private static int numOfCities;
    private static int[][] matrix;

    public static int getNumOfCities() {
        return numOfCities;
    }
    public static int[][] getMatrix() {
        return matrix;
    }


    public static Path bestPath;
    public static Path getBestPath() { return bestPath; }
    public static void setBestPath(Path bestPath) { Main.bestPath = bestPath; }


    public static void main(String[] args) throws Exception {
        String filename = args[0];
        int numThreads = parseInt(args[1]);
        int runningTime = parseInt(args[2]);
        int numPath = parseInt(args[3]);
        double mutateChance = parseDouble(args[4]);

        loadMatrix(filename);
        printMatrix(matrix);

        var threads = new TSPThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new TSPThread(runningTime, numPath, mutateChance);
            threads[i].start();
        }

        // Wait for threads to finish and sum results
        for (int i = 0; i< numThreads; i++) {
            threads[i].join();
        }
        System.out.println("The best path is: " + Arrays.toString(bestPath.getPath()));
        System.out.println("Distance: " + bestPath.getDist());

    }


    public static void loadMatrix(String filename) throws IOException  {
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