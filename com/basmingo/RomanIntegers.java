package com.basmingo;

import java.util.HashMap;
import java.util.Map;

public class RomanIntegers {
    public static void main(String[] args) {
        System.out.println(romanToInt("CMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> numbers = new HashMap<>();
        numbers.put('I', 1);
        numbers.put('V', 5);
        numbers.put('X', 10);
        numbers.put('L', 50);
        numbers.put('C', 100);
        numbers.put('D', 500);
        numbers.put('M', 1000);
        int result = 0;

        int i = 0;
        while (i < s.length()) {
            int leftNum = numbers.get(s.charAt(i));

            if (i != s.length() - 1) {
                int rightNum = numbers.get(s.charAt(i + 1));
                if (leftNum >= rightNum) {
                    result += leftNum;
                }

                else {
                    result -= leftNum;
                }
            }

            else result += leftNum;
            i++;
        }
        return result;
    }
}
