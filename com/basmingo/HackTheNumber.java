package com.basmingo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class HackTheNumber {
    public static boolean f(String input, String input2) {
        String[] input2Array = input2.split(" ");
        long leftDivider = Long.parseLong(input2Array[0]);
        long rightDivider = Long.parseLong(input2Array[1]);

        int i = 0;
        int d = input.length();

        long startNum = Integer.parseInt(input.substring(0, 1));
        long endStartNum = Integer.parseInt(input.substring(input.length() - 1));

        long remainder = startNum % leftDivider;

        while (i < input.length() - 1) {
            while (i < input.length() - 1) {
                i++;
                int testt = Character.getNumericValue(input.charAt(i));
                remainder = ( remainder * 10 + testt ) % leftDivider;

                if (remainder == 0) break;
            }


            d = input.length()-2;
            int j = 0;
            long endRemainder = endStartNum % rightDivider;
            while (d > i) {
                j++;
                while (input.charAt(d) == '0') {
                    d--;
                    j++;
                }

                int test = Character.getNumericValue(input.charAt(d));
                endRemainder =  ((long) (test * Math.pow(10, j)) + endRemainder) % rightDivider;
                d--;
            }

            if (endRemainder == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String input2 = reader.readLine();
        System.out.println(f(input, input2));
    }
}
