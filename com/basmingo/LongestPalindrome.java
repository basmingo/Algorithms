package com.basmingo;

public class LongestPalindrome {
    public static boolean isPalindrome(String input) {
        int stringSize = input.length();
        for (int i = 0; i < stringSize / 2; i++) {
            if (input.charAt(i) != input.charAt(stringSize - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static String longestPalindrome(String s) {
        int size = s.length();
        int substringSizeMax = 0;
        String result = s.substring(0, 1);

        for (int i = 0; i < size; i++) {
            System.out.println(size);
            int j = size ;
            while (! isPalindrome(s.substring(i, j))) {
                j--;
            }

            int substringLength = s.substring(i, j).length();
            if(substringLength > substringSizeMax) {
                result = s.substring(i, j);
                substringSizeMax = substringLength;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

}
