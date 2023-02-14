package com.nosenko.pzp;

public class Number implements Printable {
    public Integer number;

    public Number(Integer number) {
        this.number = number;
    }

    public int getSumOfDigits(){
        int digit, sum = 0;
        int num = Math.abs(number);
        while(num > 0)
        {
            //finds the last digit of the given number
            digit = num % 10;
            //adds last digit to the variable sum
            sum = sum + digit;
            //removes the last digit from the number
            num = num / 10;
        }
        return sum;
    }

    public int getLastDigit(){
        return (Math.abs(number) % 10);
    }

    public boolean isTwoDigit(){
        int length = 0;
        long temp = 1;
        int num = Math.abs(number);
//        e.g.
//        num = 21 tmp = 1;
//        [length = 1] 1 < 21 => [2] 10 < 21 => [3] 100 > 21 => length = 2
        while (temp <= num) {
            length++;
            temp *= 10;
        }
        return length == 2;
    }

    @Override
    public void print() {
        System.out.print(number + " ");
    }
}
