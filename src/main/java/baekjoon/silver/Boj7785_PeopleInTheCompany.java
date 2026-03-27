package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj7785_PeopleInTheCompany {
    static void quickSort(String[] arr, int left, int right) {
        if (left >= right) return;

        int partition = partition(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition, right);
    }

    static int partition(String[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        String pivot = arr[mid];

        while (left <= right) {
            while (arr[left].compareTo(pivot) > 0) left++;
            while (arr[right].compareTo(pivot) < 0) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());

        String[] inputs = new String[n];

        for (int i = 0; i < n; i++) {
            inputs[i] = input.readLine().split(" ")[0];
        }

        quickSort(inputs, 0, n - 1);

        int count = 0;

        for (int i = 0 ; i < n - 1; i++) {
            String current = inputs[i];
            String next = inputs[i + 1];

            count++;

            if (!current.equals(next)) {
                if (count % 2 != 0) sb.append(current).append('\n');

                count = 0;
            }

            if (i == n - 2) {
                if (!current.equals(next)) {
                    sb.append(next);
                } else {
                    if ((count + 1) % 2 != 0) sb.append(next);
                }
            }
        }

        System.out.println(sb);
    }
}
