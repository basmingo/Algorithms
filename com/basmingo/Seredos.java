package com.basmingo;

import java.util.HashSet;
import java.util.Set;

public class Seredos {
    public static void main(String[] args) {
        String A = "ABCDEFG";
        String B = "AFCHJIO";
        StringBuilder C = new StringBuilder();


        Set<Character> aSet = new HashSet<>();
        for (var i : A.toCharArray()) {
            aSet.add(i);
        }

        for (int i = 0; i < B.length(); i++) {
            if (B.charAt(i) == A.charAt(i)) C.append('P');
            else if (aSet.contains(B.charAt(i))) C.append('S');
            else C.append('L');
        }

        System.out.println(C);
    }

}
