package org.example;

import java.math.BigInteger;

public class PolynomialSecretSolver1 {

    public static BigInteger convertBase(String value, int base) {
        return new BigInteger(value, base);
    }

    public static BigInteger lagrangeInterpolation(int[] x, BigInteger[] y, int k) {
        BigInteger c = BigInteger.ZERO;

        for (int i = 0; i < k; i++) {
            BigInteger product = y[i];

            for (int j = 0; j < k; j++) {
                if (i != j) {
                    product = product.multiply(BigInteger.ZERO.subtract(BigInteger.valueOf(x[j])))
                            .divide(BigInteger.valueOf(x[i] - x[j]));
                }
            }

            c = c.add(product);
        }

        return c;
    }

    public static void main(String[] args) {
        int n1 = 4;
        int k1 = 3;
        int[] x1 = {1, 2, 3};
        String[] values1 = {"4", "111", "12", "213"};
        int[] bases1 = {10, 2, 10, 4};

        int n2 = 9;
        int k2 = 6;
        int[] x2 = {1, 2, 3, 4, 5, 6};
        String[] values2 = {"28735619723837", "1A228867F0CA", "32811A4AA0B7B", "917978721331A", "1A22886782E1", "28735619654702"};
        int[] bases2 = {10, 16, 12, 11, 16, 10};

        BigInteger[] y1 = new BigInteger[k1];
        for (int i = 0; i < k1; i++) {
            y1[i] = convertBase(values1[i], bases1[i]);
        }
        BigInteger constantTerm1 = lagrangeInterpolation(x1, y1, k1);
        System.out.println("The constant term (c) of the polynomial for Test Case 1 is: " + constantTerm1);

        BigInteger[] y2 = new BigInteger[k2];
        for (int i = 0; i < k2; i++) {
            y2[i] = convertBase(values2[i], bases2[i]);
        }
        BigInteger constantTerm2 = lagrangeInterpolation(x2, y2, k2);
        System.out.println("The constant term (c) of the polynomial for Test Case 2 is: " + constantTerm2);
    }
}
