package com.basmingo;
import java.io.IOException;
import java.util.*;


public class Contest {
    public static int Andrey(int[] input) {
        int result = 0;
        for (int i = 1; i < input.length; i++) {
            int left = input[i - 1];
            int right = input[i];

            if (left <= right) {
                result = result + (right - left);
            }
            else return -1;
        }
        return result;
    }

    public static int Graph(int A) {
        int result = 0;
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A - 1; j++) {
                result += (A - 3);
            }
        }

        result += 1;

        return result;
    }

//    public static void Plain(
//            String[] rowsInput,
//            String[] passengersInput) {
//
//        int amountOfRows = rowsInput.length;
//        List<Character[]> leftSits = new ArrayList<>();
//        List<Character[]> rightSits = new ArrayList<>();
//
//        for (int i = 0; i < rowsInput.length; i++) {
//            leftSits.add(new Character[]{'A', 'B', 'C'});
//            rightSits.add(new Character[]{'D', 'E', 'F'});
//        }
//
//
//
//        for (var passengerQuery : passengersInput) {
//            String[] passengers = passengerQuery.split(" ");
//            int passengersAmount = Integer.parseInt(passengers[0]);
//            String rowSide = passengers[1];
//            String sitsSide = passengers[2];
//
//            int rowPointer = 0;
//            int sitPointer = 0;
//            int globalSitPtr = 0;
//
//            if (rowSide.equals("left") && sitsSide.equals("window")) {
//                for (rowPointer = 0; rowPointer < amountOfRows; rowPointer++) {
//                    int freeSits = 0;
//                    for (sitPointer = 0; sitPointer < 3; sitPointer++) {
//                        if (leftSits.get(rowPointer)[sitPointer] != '#') {
//                            freeSits++;
//                        }
//                    }
//                    if (freeSits >= passengersAmount) {
//                        isPossibleToSit = true;
//                        break;
//                    }
//                }
//            }
//        }
//
//    }
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        int amount = scanner.nextInt();
//        int[] input = new int[amount];
//
//        int i = 0;
//        while (scanner.hasNext()) {
//            input[i] = scanner.nextInt();
//            i++;
//        }
        System.out.println(Graph(4));
    }
}