package com.basmingo;

public class DivideTwoIntegers {
    public static int divide(int divide, int divider) {
        long a = (long) divide;
        long b = (long) divider;
        int aSignature = Long.signum(a);
        int bSignature = Long.signum(b);

        Long checkVal;
        Long result = 0L;
        int intresult = 0;

        if ((aSignature == 1 && bSignature == 1)) {
            if (a >= Integer.MAX_VALUE && b == 1) return Integer.MAX_VALUE;
            checkVal = (long) b;
            while (checkVal <= a) {
                checkVal += b;
                result++;
            }
        }
        else if ((aSignature == -1 && bSignature == -1)) {
            if (a <= Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
            a = -a;
            b = -b;
            checkVal = (long) b;
            while (checkVal <= a) {
                checkVal += b;
                result++;
            }
        }
        else if ((aSignature == - 1 && bSignature == 1)) {
            if (a <= Integer.MIN_VALUE && b == 1) return Integer.MIN_VALUE;
            checkVal = (long) -b;
            while (checkVal >= a) {
                checkVal -= b;
                result--;
            }
        }
        else if ((aSignature == 1 && bSignature == -1)) {
            if (a >= Integer.MAX_VALUE && b == -1) return Integer.MIN_VALUE;
            a = -a;
            b = -b;
            checkVal = (long) -b;
            while (checkVal >= a) {
                checkVal -= b;
                result--;
            }
        }

        if (result > Integer.MAX_VALUE) {
            intresult = Integer.MAX_VALUE;
        }
        else if (result < Integer.MIN_VALUE) {
            intresult = Integer.MIN_VALUE;
        }
        else {
            intresult = result.intValue();
        }

        return intresult;
    }

    public static void main(String[] args) {
        System.out.println(divide(-10, -3));
        System.out.println(divide(10, -3));
        System.out.println(divide(-10, 3));
        System.out.println(divide(10, 3));
        System.out.println(divide(0, 3));
        System.out.println(divide(0, -3));
        System.out.println(divide(-0, -3));
        System.out.println(divide(-0, 3));

        System.out.println(divide(-9, -3));

        System.out.println(divide(-2147483648, -3));
    }
}
