package com.basmingo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class AliceAndZeliboba {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] aliceName2 = reader.readLine().toCharArray();
        char[] zelibobaName2 = reader.readLine().toCharArray();
        Set<Character> aliceLiterals = new HashSet<>();
        char[] result2 = new char[aliceName2.length];

        for (int i = 0; i < aliceName2.length; i++) {
            if (zelibobaName2[i] == aliceName2[i]) {
                result2[i] = 'P';
                aliceName2[i] = '_';
            }
        }

        for (var i : aliceName2) {
            aliceLiterals.add(i);
        }

        for (int i = 0; i < zelibobaName2.length; i++) {
            if (aliceLiterals.contains(zelibobaName2[i]) && result2[i] != 'P') {
                result2[i] = 'S';
                aliceLiterals.remove(zelibobaName2[i]);
            }
            else {
                if (result2[i] != 'S' && result2[i] != 'P') result2[i] = 'I';
            }

        }

        System.out.println(String.valueOf(result2));
    }
}
