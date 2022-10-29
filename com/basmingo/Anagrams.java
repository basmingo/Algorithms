package com.basmingo;

import java.util.*;

public class Anagrams {
    public static List<List<String>> anagramMain(String[] input) {
        Map<Map<Character, Integer>, List<String>> data = new HashMap<>();
        for (String item : input) {
            saveOrUpdate(data, item);
        }

        return data.values().stream().toList();
    }

    private static Map<Character, Integer> toMap(String string) {
        Map<Character, Integer> result = new HashMap<>();
        for (char i : string.toCharArray()) {
            result.merge(i, 1, Integer::sum);
        }
        return result;
    }


    private static void saveOrUpdate(
            Map<Map<Character, Integer>, List<String>> inputData,
            String inputString) {
        Map<Character, Integer> inputMap = toMap(inputString);

        if (inputData.containsKey(inputMap)) {
            List<String> listString = inputData.get(inputMap);
            listString.add(inputString);
            inputData.put(inputMap, listString);
        }
        else {
            List<String> listString = new ArrayList<>();
            listString.add(inputString);
            inputData.put(inputMap, listString);
        }
    }

    public static void main(String[] args) {
        String[] i1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] i2 = {"ddddddddddg", "dgggggggggg"};
        System.out.println(anagramMain(i1));
        System.out.println(anagramMain(i2));
        System.out.println(anagramMain(new String[]{"ba", "bba", "abb", "ab", "aabb"}));
        System.out.println(anagramMain(new String[]{""}));
    }
}
