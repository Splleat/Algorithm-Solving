package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11651_SortingCoordinate2 {
    public static void quickSort(int[] x, int[] y, int left, int right) {
        if (left >= right) return;

        int partition = partition(x, y, left, right);
        quickSort(x, y, left, partition - 1);
        quickSort(x, y, partition, right);
    }

    public static int partition(int[] x, int[] y, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivotX = x[mid];
        int pivotY = y[mid];

        while (left <= right) {
            while (compare(x[left], y[left], pivotX, pivotY) < 0) left++;
            while (compare(x[right], y[right], pivotX, pivotY) > 0) right--;

            if (left <= right) {
                swap(x, left, right);
                swap(y, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            String inputStr = input.readLine();
            String[] parts = inputStr.split(" ");

            x[i] = Integer.parseInt(parts[0]);
            y[i] = Integer.parseInt(parts[1]);
        }

        quickSort(x, y, 0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(x[i]).append(" ").append(y[i]).append('\n');
        }

        System.out.println(sb);
    }

    public static int compare(int aX, int aY, int bX, int bY) {
        if (aY != bY) {
            return aY - bY;
        }

        return aX - bX;
    }
}
