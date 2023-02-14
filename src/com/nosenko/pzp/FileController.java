package com.nosenko.pzp;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileController {

    private FileController(){};

    public static ArrayList<Double> loadData(String filePath){
        ArrayList<Double> arrayList = new ArrayList<>();
        File file = new File(filePath);
        // read data
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            while ((text = reader.readLine()) != null) {
//                split "1.1 0.1"
                String[] parts = text.split(" ");
                for (String part : parts) {
                    arrayList.add(Double.parseDouble(part));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("File %s not found ", filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static LinkedList<Number> loadNumbers(String filePath){

        LinkedList<Number> list = new LinkedList<>();
        File file = new File(filePath);
        // read data
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String text;
            while ((text = reader.readLine()) != null) {
                String[] parts = text.split("\\s+");
                for (String part : parts) {
                    Integer num = Integer.parseInt(part);

                    list.add(new Number(num));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("Load numbers: ERROR File %s not found ", filePath);
        } catch (NumberFormatException e){
            System.out.printf("Load numbers: ERROR incorrect value %s", e.getMessage());
            list.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
