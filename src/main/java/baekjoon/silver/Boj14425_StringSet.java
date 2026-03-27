package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj14425_StringSet {
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
            while (arr[left].compareTo(pivot) < 0) left++;
            while (arr[right].compareTo(pivot) > 0) right--;

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

    static boolean binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid].compareTo(target) == 0) {
                return true;
            } else if (arr[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNumbers = input.readLine().split(" ");

        int n = Integer.parseInt(inputNumbers[0]);
        int m = Integer.parseInt(inputNumbers[1]);

        String[] own = new String[n];

        for (int i = 0; i < n; i++) {
            own[i] = input.readLine();
        }

        quickSort(own, 0, n - 1);

        int match = 0;

        for (int i = 0; i < m; i++) {
            if (binarySearch(own, input.readLine())) {
                match++;
            }
        }

        System.out.println(match);
    }
}
