package com.basmingo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Data {
    public List<Integer> numbers;
    public boolean isGood;

    public Data(List<Integer> numbers) {
        this.numbers = numbers;
        this.isGood = false;
    }

    public Data(List<Integer> numbers, boolean isGood) {
        this.numbers = numbers;
        this.isGood = isGood;
    }
}

public class Eratosfen {
    static int iteration = 0;
    public static Data filter(Data A) {
        if (iteration > A.numbers.size()) {
            return new Data(A.numbers, true);
        }

        int divider = A.numbers.get(iteration);
        iteration++;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= iteration; i++) {
            result.add(A.numbers.get(i));
        }

        for (int j = 1; j < A.numbers.size(); j++) {
            int dividingNum = A.numbers.get(j);

            if (dividingNum % divider != 0) {
                result.add(dividingNum);
            }
        }

        return new Data(result);
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        int size = 100;
        for (int i = 2; i < size; i++) {
            input.add(i);
        }

        Data inputData = new Data(input);

        while (! inputData.isGood) {
            System.out.println(inputData.numbers);
            inputData = filter(inputData);
        }

        System.out.println(inputData.numbers);
    }
}
