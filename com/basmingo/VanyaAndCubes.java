package com.basmingo;

public class VanyaAndCubes {
    public static int calcCubes(int num) {

        int height = 1;
        int previousAmount = 1;
        int cubesTotal = 0;

        while (cubesTotal < num) {

            height++;
            cubesTotal += previousAmount + height;
            previousAmount += height;
        }

        return height - 1;
    }


    public static void main(String[] args) {
        System.out.println(calcCubes(19));
    }
}
