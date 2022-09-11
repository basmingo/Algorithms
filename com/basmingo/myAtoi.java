package com.basmingo;

import java.io.CharArrayReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class myAtoi {
    //task 8

    static boolean isPositive;
    public static void main(String[] args) {

        System.out.println(processList(convertStringToList("        +-31 a123")) == 0);
        System.out.println(processList(convertStringToList("        +31")) == 31);
        System.out.println(processList(convertStringToList("        -100500")) == -100500);
        System.out.println(processList(convertStringToList("a 31")) == 0);
        System.out.println(processList(convertStringToList(" -31a")) == -31);
        System.out.println(processList(convertStringToList("        +a")) == 0);
        System.out.println(processList(convertStringToList("-b")) == 0);
        System.out.println(processList(convertStringToList("a")) == 0);

        System.out.println(processList(convertStringToList("2147483647")) == 2147483647);
        System.out.println(processList(convertStringToList("2147483646")) == 2147483646);
        System.out.println(processList(convertStringToList("2147483648")) == 2147483647);

        System.out.println(processList(convertStringToList("-2147483648")) == -2147483648);
        System.out.println(processList(convertStringToList("-2147483649")) == -2147483648);

        System.out.println(processList(convertStringToList("21474836460")) == 2147483647);
        System.out.println(processList(convertStringToList("00000-42a1234")) == 0);
        System.out.println(processList(convertStringToList("0000042 a1234")) == 42);
        System.out.println(processList(convertStringToList("00000+42 a1234")) == 0);
        System.out.println(processList(convertStringToList("20000000000000000000")) == 2147483647);
        System.out.println(processList(convertStringToList("     0000000000012345678")) == 12345678);

        System.out.println(processList(convertStringToList("20000000000000000000")));
    }

    public static List<Integer> convertStringToList(String input) {
        isPositive = true;
        List<Integer> resultList = new ArrayList<>();
        boolean parsingStarted = false;

        char[] charArray = input.toCharArray();
        for (char i : charArray) {
            if (!parsingStarted & !isNumeric(i)) {
                if (i == '-') {
                    isPositive = false;
                    parsingStarted = true;
                }
                else if (i == '+') {
                    parsingStarted = true;
                }
                else if (i != ' ') {
                    break;
                }
            }
            else if(!parsingStarted & i == '0') {
                parsingStarted = true;
            }

            else if(parsingStarted & !isNumeric(i)) break;

            else {
                parsingStarted = true;
                resultList.add(Character.getNumericValue(i));
            }
        }

        return resultList;
    }

    public static List<Integer> cleanLeadingZeros (List<Integer> input) {
        List<Integer> resultList = new ArrayList<>();
        boolean parsingStarted = false;
        for (Integer i : input){
            if (! parsingStarted & i != 0) {
                parsingStarted = true;
                resultList.add(i);
            }
            else if (parsingStarted) {
                resultList.add(i);
            }
        }

        return resultList;
    }

    public static int processList(List<Integer> input) {
        int iteration = 0;
        long preResult = 0;
        int result = 0;

        input = cleanLeadingZeros(input);

        if (input.size() > 10) {
            return (isPositive) ? 2147483647 : -2147483648;
        }

        for (int i = input.size() - 1; i >= 0; i--) {
            preResult += input.get(i) * (long) Math.pow(10, iteration);
            iteration++;
        }

        preResult = (isPositive) ? preResult : -preResult;

        if (preResult > 2147483647) {
            result = 2147483647;
        }
        else if (preResult < -2147483648) {
            result = -2147483648;
        }
        else {
            result = (int)preResult;
        }

        return result;
    }

    private static boolean isNumeric(Character c) {
        Set<Character> numbers = Set.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        return numbers.contains(c);
    }
}
