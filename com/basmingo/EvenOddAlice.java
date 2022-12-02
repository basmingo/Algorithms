package com.basmingo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EvenOddAlice {
    static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(new File("com/basmingo/resources/EvenOddAlice.txt")));
        int numOfInput = Integer.parseInt(bufferedReader.readLine());


        bufferedReader.readLine();
        List<Integer> numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(Integer::parseInt).toList();

        long evenCount = numbers.stream().filter(x -> x % 2 == 0).count();
        long oddCount = numbers.stream().filter(x -> x % 2 != 0).count();

        if(oddCount == 2) {

        }

    }

}
