package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10815_NumberCard {
    static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int partition = partition(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition, right);
    }

    static int partition(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = arr[mid];

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

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());

        String[] parts1 = input.readLine().split(" ");

        int m = Integer.parseInt(input.readLine());

        String[] parts2 = input.readLine().split(" ");

        int[] own = new int[n];

        for (int i = 0; i < n; i++) {
            own[i] = Integer.parseInt(parts1[i]);
        }


        int[] given = new int[m];

        for (int i = 0; i < m; i++) {
            given[i] = Integer.parseInt(parts2[i]);
        }

        quickSort(own, 0, own.length - 1);

        for (int i = 0; i < m; i++) {
            if (binarySearch(own, given[i])) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
