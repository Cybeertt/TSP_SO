package com.company;

import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Scanner read = new Scanner(System.in);

    private static int numOfCities;

    private static int[][] way = new int[numOfCities][numOfCities];

    private static int[][] distances;

    private static final Travelling tsp = new Travelling(0);

    public static void main(String[] args) throws IOException {
        //readTextFile();

        String file;
        file = read.nextLine();
        load(file);


    }

    public static void load(String filename) throws IOException  {
        FileReader file;
        BufferedReader buffer;

        try {
            file = new FileReader(filename + ".txt");
            buffer = new BufferedReader(file);
            tsp.setNumCities(Integer.parseInt(buffer.readLine()));

            int numcities = tsp.getNumCities();
            int[][] cost = new int[numcities][numcities];
            System.out.println(numcities);

            int row = 0;
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] tokenizer = line.trim().split(" +");

                for (int j = 0; j < tokenizer.length; j++) {
                    cost[row][j] = Integer.parseInt(tokenizer[j]);
                    tsp.setDistances(cost);
                    System.out.println(tsp.getDistances());
                }

                row++;
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

       /*FileReader file;
       BufferedReader buffer;
       try {
           file = new FileReader(filename + ".txt");
           buffer = new BufferedReader(file);
           tsp.setNumCities(Integer.parseInt(buffer.readLine()));

           int[][] way = new int[tsp.getNumCities()][tsp.getNumCities()];
           //System.out.println(tsp.getNumCities());

           int numberOfLines = 0;
           String line = buffer.readLine();
           while((line = buffer.readLine()) !=null){

               String[] dist = buffer.readLine().split(" ");
               for (int j=0; j<dist.length; j++) {
                   way[numberOfLines][j] = Integer.parseInt(dist[j]);
               }
               numberOfLines++;
           }

               while (line != null){
                   try {
                       System.out.println(Integer.parseInt(line));
                   } catch (NumberFormatException nfe) {
                       System.err.println("Failed to parse integer from line:" + line);
                       System.err.println(nfe.getMessage());
                       System.exit(1);
                   }
                   line = buffer.readLine();

               }


           while ((dist = buffer.readLine()) != null) {
               for (int i = 0; i < tsp.getNumCities(); i++) {
                   //way[numberOfLines][i] = Integer.parseInt(dist[i]);
                   list.add(Integer.parseInt(dist));
               }

           }
           int i = 0;
           String line;
           while((line = buffer.readLine()) != null) {
               StringTokenizer st = new StringTokenizer (line);
               int num=0;
               //the next line is when you need to calculate the number of columns
               //otherwise leave blank
               way[i] = new int[st.countTokens()];
               while (st.hasMoreTokens()){
                   int value1 = Integer.parseInt(st.nextToken());
                   way[i][num] = value1;
                   num++;
               }
               i++;
           }*/

           /*for(int i = 0; i < tsp.getNumCities(); i++)
               way[i][i] = 0;

           for(int i = 0; i < tsp.getNumCities(); i++)
           {
               StringTokenizer st = new StringTokenizer(buffer.readLine());
               for(int j = 0; j <= i; j++)
               {
                   way[i][j] = Integer.parseInt(st.nextToken());
                   way[j][i] = way[i][j];
                   //tsp.s
                   System.out.print(way[i][j] + " ");
               }
           }

           buffer.close();*/



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