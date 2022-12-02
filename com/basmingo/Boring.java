package com.basmingo;

import java.io.*;
import java.util.*;

public class Boring {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("com/basmingo/resources/Boring.txt")));
        bufferedReader.readLine();
        List<Integer> numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(Integer::parseInt)
                .toList();

        Map<Integer, Integer> itemsNum = new HashMap<>();
        for (var i : numbers) {
            itemsNum.merge(i, 1, Integer::sum);
        }

        long result = reduce(itemsNum, 0);
        System.out.println(result);
    }

    private static long reduce(Map<Integer, Integer> itemsNum, long scoreTotal) {
        if (itemsNum.isEmpty()) {
            return scoreTotal;
        }

        Map<Integer, Long> scoreMap = new HashMap<>();
        itemsNum.keySet().forEach(x -> scoreMap.put(x, scores(x, itemsNum)));

        Map.Entry<Integer, Long> min = scoreMap.entrySet().iterator().next();
        for (var i : scoreMap.entrySet()) {
            if (i.getValue() < min.getValue()) {
                min = i;
            }
        }

        int minKey = min.getKey();
        scoreTotal += minKey;

        for (var i : scoreMap.entrySet()) {
            System.out.println(i.getKey().toString() + " " + i.getValue().toString() + " " + itemsNum.get(i.getKey()));
        }

        itemsNum.remove(minKey - 1);
        itemsNum.remove(minKey + 1);
        itemsNum.merge(minKey, 1 , (x, y) -> x - y);

        if (itemsNum.get(minKey) <= 0) {
            itemsNum.remove(minKey);
        }
        System.out.println("\n");
        return reduce(itemsNum, scoreTotal);
    }

    static long scores(int number, Map<Integer, Integer> inputMap) {
        long result = Optional.ofNullable(inputMap
                        .get(number - 1))
                        .map(x -> x * (number - 1))
                        .orElse(0);

        result += Optional.ofNullable(inputMap
                        .get(number + 1))
                        .map(x -> x * (number + 1))
                        .orElse(0);

        return result;
    }
}
