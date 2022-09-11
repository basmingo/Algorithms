package com.basmingo;

public class PolygonTest {
    public static void main(String[] args) {
        int[] input = {6, 10, 7, 2, 3, 4, 1, 35};
        System.out.println(polygonTest(input));
    }

    public static boolean polygonTest(int[] input) {
        int max = 0;
        int sum = 0;

        for (var i : input) {
            max = Math.max(i, max);
            sum += i;
        }
        return max < sum / 2;
    }
}
