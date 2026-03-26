package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Boj2751_SortingNumbers2 {
    public static void quickSort(int[] arr, int left, int right, Random random) {
        if (left >= right) return;

        int partition = partition(arr, left, right, random);

        quickSort(arr, left, partition - 1, random);
        quickSort(arr, partition, right, random);
    }

    public static int partition(int[] arr, int left, int right, Random random) {
        int randomIdx = random.nextInt(right - left + 1) + left;

        int pivot = arr[randomIdx];

        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

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
        Random random = new Random();

        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input.readLine());
        }

        quickSort(arr, 0, arr.length - 1, random);

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.println(sb);
    }
}
