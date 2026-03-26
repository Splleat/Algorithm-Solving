package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1427_SortInside {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int partition = partition(arr, left, right);

        quickSort(arr, left, partition - 1);
        quickSort(arr, partition, right);
    }

    public static int partition(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = arr[mid];

        while (left <= right) {
            while (arr[left] > pivot) left++;
            while (arr[right] < pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
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

        String str = String.valueOf(n);

        int[] arr = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }

        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            sb.append(i);
        }

        System.out.println(sb);
    }
}
