package com.kid.clrs.ch2;

import java.util.Arrays;
import java.util.Scanner;

public class Problems4D {

    public static void main(String[] args) {
        System.out.println("please input the size of array");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println("please input the elements of array");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        in.close();

        System.out.println(Arrays.toString(array));
        System.out.println(countInversions(array, 0, n - 1));
    }

    public static int countInversions(int[] array, int p, int r) {
        int inversions = 0;
        if (p < r) {
            int q = (int) Math.floor((p + r) / 2);
            inversions = inversions + countInversions(array, p, q);
            inversions = inversions + countInversions(array, q + 1, r);
            inversions = inversions + mergeInversions(array, p, q, r);
        }
        return inversions;
    }

    private static int mergeInversions(int[] array, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] leftArray = new int[n1 + 1];
        int[] rightArray = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[p + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[q + j + 1];
        }

        leftArray[n1] = Integer.MAX_VALUE;
        rightArray[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int inversions = 0;
        boolean counted = false;

        for (int k = p; k <= r; k++) {
            if (!counted && rightArray[j] < leftArray[i]) {
                inversions = inversions + n1 - i;
                counted = true;
            }

            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
                counted = false;
            }
        }
        return inversions;
    }
}
