package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10814_SortingAge {
    public static void quickSort(int[][] intArr, String[] strArr, int left, int right) {
        if (left >= right) return;

        int partition = partition(intArr, strArr, left, right);
        quickSort(intArr, strArr, left, partition - 1);
        quickSort(intArr, strArr, partition, right);
    }

    public static int partition(int[][] intArr, String[] strArr, int left, int right) {
        int mid = left + (right - left) / 2;

        int[] pivot = intArr[mid];

        int i = left;
        int j = right;

        while (i <= j) {
            while (compare(intArr[i], pivot) < 0) i++;
            while (compare(intArr[j], pivot) > 0) j--;

            if (i <= j) {
                swap(intArr, strArr, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    public static int compare(int[] a, int[] b) {
        if (a[0] != b[0]) {
            return a[0] - b[0];
        }

        return a[1] - b[1];
    }

    public static void swap(int[][] intArr, String[] strArr, int a, int b) {
        int[] intTemp = intArr[a];
        intArr[a] = intArr[b];
        intArr[b] = intTemp;

        String strTemp = strArr[a];
        strArr[a] = strArr[b];
        strArr[b] = strTemp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());

        int[][] intArr = new int[n][2];
        String[] strArr = new String[n];

        for (int i = 0; i < n; i++) {
            String[] parts = input.readLine().split(" ");
            intArr[i][0] = Integer.parseInt(parts[0]);
            intArr[i][1] = i;
            strArr[i] = parts[1];
        }

        quickSort(intArr, strArr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(intArr[i][0]).append(" ").append(strArr[i]).append('\n');
        }

        System.out.println(sb);
    }
}
