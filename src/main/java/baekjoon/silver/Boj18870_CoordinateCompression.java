package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj18870_CoordinateCompression {
    public static void quickSort(int[][] arr, int left, int right) {
        if (left >= right) return;

        int partition = partition(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition, right);
    }

    public static int partition(int[][] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = arr[mid][0];

        while (left <= right) {
            while (arr[left][0] < pivot) left++;
            while (arr[right][0] > pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    public static int binarySearch(int[][] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid][0] == target) {
                return arr[mid][1];
            } else if (arr[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void swap(int[][] arr, int a, int b) {
        int temp = arr[a][0];
        arr[a][0] = arr[b][0];
        arr[b][0] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());

        String[] parts = input.readLine().split(" ");

        int[] original = new int[n];
        int[][] sorted = new int[n][2];

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(parts[i]);
            original[i] = val;
            sorted[i][0] = val;
        }

        quickSort(sorted, 0, n - 1);

        int k = 0;

        for (int i = 1; i < n; i++) {
            if (sorted[i-1][0] != sorted[i][0]) k++;
            sorted[i][1] = k;
        }

        for (int i = 0; i < n; i++) {
            sb.append(binarySearch(sorted, original[i])).append(" ");
        }

        System.out.println(sb);
    }
}
