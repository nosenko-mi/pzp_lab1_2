package com.nosenko.pzp;

// Є текстовий файл із цілими числами. Потрібно спочатку всі числа з даного файлу записати у двозв'язний лінійний список.
// Потім видалити зі списку всі елементи, що мають властивість Q.
// Після чого продублювати всі елементи, що мають властивість R.
// Врешті-решт, впорядкувати всі елементи лінійного списку, що мають властивість T, залишивши останні елементи на своїх місцях.
// Властивості Q, R і T вказані в індивідуальних варіантах.
// Після кожного перетворення лінійного списку вивести його на екран.
//        Програма має містити наступні функції:
//        •	створення списку та заповнення його цілими числами з текстового файлу;
//        •	виведення списку на екран;
//        •	видалення всіх елементів списку, що мають властивість Q;
//        •	дублювання всіх елементів списку, що мають властивість R;
//        •	сортування всіх елементів списку, що мають властивість T;
//        •	видалення всього списку.
//8.	Q: сума цифр числа дорівнює 10. R: число містить у молодшому розряді цифру 3. T: число є двозначним.

import java.util.*;

public class Main {

    public static void main(String[] args) {
       final int q = 10;
       final int r = 3;

//        create linked list
        LinkedList<Number> list = FileController.loadNumbers("numbers.txt");

        if (!isValidNumbers(list)){
            return;
        }
//        print list
        System.out.println("Given list:");
        Printer.print(list);
//        Q
        System.out.println("Remove elements that have the Q property (the sum of the digits of the number is 10)");
        sequenceQ(list, q);
        Printer.print(list);
//        R
        System.out.println("Duplicate elements that have the R property (the number contains the least significant digit 3)");
        sequenceR(list, r);
        Printer.print(list);
//        T
        System.out.println("Order only the elements that have the T property (the number is two-digit)");
        sequenceT(list);
        Printer.print(list);

        list.clear();

    }

    private static void sequenceQ(LinkedList<Number> list, int qParam){
        list.removeIf(item -> (item.getSumOfDigits() == qParam));
    }

    private static void sequenceR(LinkedList<Number> list, int rParam){
        ListIterator<Number> iter = list.listIterator();
        while(iter.hasNext()){
            var item = iter.next();
            if(item.getLastDigit() == rParam){
                iter.add(item);
            }
        }
    }

    private static void sequenceT(LinkedList<Number> list){
        List<Number> twoDigitList = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();

//        find all two-digit numbers and their indices
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).isTwoDigit()){
                twoDigitList.add(list.get(i));
                indices.add(i);
            }
        }
//        sort two-digit numbers
        twoDigitList.sort((Comparator.comparing(o -> o.number)));
//        change given list
        for (int i = 0; i < twoDigitList.size(); i++){
            list.set(indices.get(i), twoDigitList.get(i));
        }
    }

    private static boolean isValidNumbers(LinkedList<Number> list) {
        return list.size() != 0;
    }
}
