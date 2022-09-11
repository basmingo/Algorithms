package com.basmingo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 */
public class MaximumArea {
    public static void main(String[] args) {
       int h = 1000000000;
       int w = 1000000000;
       int[] horizontalCuts = {2};
       int[] verticalCuts = {2};
       System.out.println(maxArea(h, w, horizontalCuts, verticalCuts));
    }

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        List<Integer> horizontalCutsList = Arrays.stream(horizontalCuts).boxed().sorted().collect(Collectors.toList());
        List<Integer> verticalCutsList = Arrays.stream(verticalCuts).boxed().sorted().collect(Collectors.toList());
        horizontalCutsList.add(h);
        verticalCutsList.add(w);

        int horizontalMaxSpace = maxSpace(horizontalCutsList);
        int verticalMaxSpace = maxSpace(verticalCutsList);

        long resultSpace = (long) horizontalMaxSpace * verticalMaxSpace;
        int resultSpaceInt;

        if (resultSpace <= 2147483647) {
            resultSpaceInt = (int) resultSpace;
        }

        else {
            resultSpaceInt = (int) (resultSpace % 1000000007);
        }

        return resultSpaceInt;
    }

    private static int maxSpace(List<Integer> cuts) {
        int maxSpace = 1;
        int prevCut = 0;
        for (int cut : cuts) {
            int space = cut - prevCut;
            if (space > maxSpace) {
                maxSpace = space;
            }
            prevCut = cut;
        }
        return maxSpace;
    }
}