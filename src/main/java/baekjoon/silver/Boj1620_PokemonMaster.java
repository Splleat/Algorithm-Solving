package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1620_PokemonMaster {
    static void quickSort(String[] strArr, int[] intArr, int left, int right) {
        if (left >= right) return;

        int partition = partition(strArr, intArr, left, right);
        quickSort(strArr, intArr, left, partition - 1);
        quickSort(strArr, intArr, partition, right);
    }

    static int partition(String[] strArr, int[] intArr, int left, int right) {
        int mid = left + (right - left) / 2;
        String pivot = strArr[mid];

        while (left <= right) {
            while (strArr[left].compareTo(pivot) < 0) left++;
            while (strArr[right].compareTo(pivot) > 0) right--;

            if (left <= right) {
                swap(strArr, intArr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    static void swap(String[] strArr, int[] intArr, int a, int b) {
        String strTemp = strArr[a];
        strArr[a] = strArr[b];
        strArr[b] = strTemp;

        int intTemp = intArr[a];
        intArr[a] = intArr[b];
        intArr[b] = intTemp;
    }

    static int binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int res = arr[mid].compareTo(target);

            if (res == 0) {
                return mid;
            } else if (res < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputs = input.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] original = new String[n];
        int[] numbers = new int[n];

        for (int i = 0 ; i < n; i++) {
            original[i] = input.readLine();

            numbers[i] = i + 1;
        }

        String[] sorted = new String[n];
        System.arraycopy(original, 0, sorted, 0, n);

        quickSort(sorted, numbers, 0, n - 1);

        for (int i = 0; i < m; i++) {
            String given = input.readLine();

            if (given.charAt(0) >= '0' && given.charAt(0) <= '9') {
                int idx = Integer.parseInt(given);
                sb.append(original[idx - 1]);
            } else {
                int idx = binarySearch(sorted, given);
                sb.append(numbers[idx]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
