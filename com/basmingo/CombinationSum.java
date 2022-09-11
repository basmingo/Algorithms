package com.basmingo;

import java.util.*;

public class CombinationSum {
    public static boolean isValid(int i) {
        return (i % 10 == 0 & i / 3 == 10);
    }

    public static void main(String[] args) {
        int number = 30;
        if (isValid(number)) {
            System.out.println("+");
        }
    }
}
