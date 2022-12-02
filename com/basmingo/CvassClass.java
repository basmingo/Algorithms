package com.basmingo;

import java.io.*;

public class CvassClass {
	static final int ONE_MILLION = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader bd = new BufferedReader(new FileReader("com/basmingo/resources/cvassclass.txt"));
		String[] firstLine = bd.readLine().split(" ");
		String[] secondLine = bd.readLine().split(" ");

		int bigCash = Integer.parseInt(firstLine[0]);
		int smallCash = Integer.parseInt(firstLine[1]);

		int bottleCost = Integer.parseInt(secondLine[0]);
		int mRmnd = Integer.parseInt(secondLine[1]);

		int btlTotal = 0;

		System.out.println(buyBottle(btlTotal, bigCash, smallCash, bottleCost, mRmnd));
	}

	static int buyBottle(int btlTotal, int bigCash, int smallCash, int bottleCost, int mRmnd) {
		if (mRmnd >= ONE_MILLION - (bottleCost % ONE_MILLION) && ONE_MILLION * bigCash >= bottleCost) {
			btlTotal++;
			bigCash -= (bottleCost + 999999) / ONE_MILLION;
			smallCash += (ONE_MILLION - (bottleCost % ONE_MILLION));
			mRmnd -= (ONE_MILLION - (bottleCost % ONE_MILLION));
		}
		else if (smallCash >= bottleCost) {
			btlTotal++;
			smallCash -= bottleCost;
			mRmnd += bottleCost;
		}
		else if (bigCash * ONE_MILLION + smallCash >= bottleCost && smallCash >= bottleCost % ONE_MILLION && bottleCost > ONE_MILLION) {
			btlTotal++;
			bigCash -= bottleCost / ONE_MILLION;
			smallCash -= (bottleCost % ONE_MILLION);
			mRmnd += (bottleCost % ONE_MILLION);
		}
		else {
			System.out.println(mRmnd + " " + smallCash + " big " + bigCash);
			return btlTotal;
		}
		System.out.println(mRmnd + " " + smallCash + " big " + bigCash);
		return buyBottle(btlTotal, bigCash, smallCash, bottleCost, mRmnd);
	}
}
