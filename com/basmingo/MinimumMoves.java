package com.basmingo;

import java.util.Arrays;

public class MinimumMoves {
    /*
    LeetCode 462
     */

    public static void main(String[] args) {
        System.out.println(minMoves(new int[] {1, 2, 3}));
    }

    public static int minMoves(int[] nums){
        long sum = 0;
        long mediana = 0;
        int minimumMoves = 0;

        Arrays.sort(nums);
        mediana = nums[nums.length / 2];
        for (int num : nums) {
            minimumMoves += (num > mediana) ? num - mediana : mediana - num;
        }
        return minimumMoves;
    }
}
