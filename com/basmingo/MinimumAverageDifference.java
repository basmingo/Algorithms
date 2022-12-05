package com.basmingo;

import java.util.Arrays;

public class MinimumAverageDifference {
    public static void main(String[] args) {
        int[] nums = {4, 2, 0};

        System.out.println(minimumAverageDifference(nums));
    }

    public static int minimumAverageDifference(int[] nums) {
        int n = 0;
        long prefix = 0;
        long postfix = Arrays.stream(nums).sum();

        long curAverage = 0;
        long smallestAverage = postfix / nums.length;

        while (n < nums.length) {
            prefix += nums[n];
            postfix -= nums[n];

            if (n < nums.length - 1) {
                curAverage = prefix / (n + 1) - postfix / (nums.length - n - 1);

            } else {
                curAverage = prefix / (n + 1) - postfix;
            }

            if (curAverage < smallestAverage) {
                smallestAverage = curAverage;
            }

            n++;
        }
        return (int) smallestAverage;
    }

}
