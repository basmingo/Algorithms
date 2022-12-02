package com.basmingo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Quests {
    public static Boolean quest(int k, Long moneyNeeded, int days, List<Integer> questsProfit) throws IOException {
        questsProfit.sort(Comparator.reverseOrder());
        long sum = 0;
        int j = 0;
        for (int i = 0; i < days; i++) {
            if (j >= k) j = 0;
            if (j < questsProfit.size()) {
                sum += questsProfit.get(j);
            }
            j++;
        }
        if (sum >= moneyNeeded) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long dataCount = Long.parseLong(bufferedReader.readLine());
        List<Integer> moneyForQuest;

        for (int i = 0; i < dataCount; i++) {
            String[] firstLine = (bufferedReader.readLine()).split(" ");
            String[] secondLine = (bufferedReader.readLine()).split(" ");
            int questsCount = Integer.parseInt(firstLine[0]);
            long moneyNeeded = Long.parseLong(firstLine[1]);
            int daysTotal = Integer.parseInt(firstLine[2]);
            moneyForQuest = new ArrayList<>();

            for (int j = 0; j < questsCount; j++) {
                moneyForQuest.add(Integer.parseInt(secondLine[j]));
            }

            int l = 0;
            int r = daysTotal;
            int m = 0;
            while(l < r) {
                m = (l + r + 1) / 2;
                if (quest(m, moneyNeeded, daysTotal, moneyForQuest)) {
                    l = m;
                }
                else {
                    r = m - 1;
                }
            }
            if (m == daysTotal && quest(m, moneyNeeded, daysTotal, moneyForQuest)) System.out.println("Infinity");
            else if (l == 0 && !quest(m, moneyNeeded, daysTotal, moneyForQuest)) System.out.println("Impossible");
            else System.out.println(l - 1);
        }
    }
}
