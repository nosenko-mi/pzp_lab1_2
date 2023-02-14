package com.nosenko.pzp;

import java.util.List;

public class Printer {

//    public static void print(List<Printable> list){
//        for (Printable item: list) {
//            item.print();
//        }
//    }

    public static void print(List<Number> list) {
        for (Number item: list) {
            item.print();
        }
        System.out.println();
    }
}
