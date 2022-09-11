package com.basmingo;

import java.util.Locale;

public class Palindrome {
    public static void main(String[] args) {
        String testA = "A ba c ab A";
        String testB = "Ba a aa B";
        String testC = "C";
        String testD = "Cc";
        String testE = "  C e    aec ";

        System.out.println(palindromeTest(testA));
        System.out.println(palindromeTest(testB));
        System.out.println(palindromeTest(testC));
        System.out.println(palindromeTest(testD));
        System.out.println(palindromeTest(testE));
    }

    public static boolean palindromeTest(String input) {
        input = input.toLowerCase(Locale.ROOT);
        input = input.replaceAll("\\s", "");
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) return false;

            left++;
            right--;
        }
        return true;
    }
}
