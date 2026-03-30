package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1764_Unknown {
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

    static boolean binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid].equals(target)) {
                return true;
            } else if (arr[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = reader.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] unListen = new String[n];

        for (int i = 0; i < n; i++) {
            unListen[i] = reader.readLine();
        }

        quickSort(unListen, 0, unListen.length - 1);

        int count = 0;

        String[] givens = new String[Math.max(m, n)];

        for (int i = 0; i < m; i++) {
            String given = reader.readLine();

            if (binarySearch(unListen, given)) {
                givens[count++] = given;
            }
        }

        String[] answer = new String[count];

        System.arraycopy(givens, 0, answer, 0, count);

        quickSort(answer, 0, answer.length - 1);

        for (int i = 0; i < count; i++) {
            sb.append(answer[i]).append('\n');
        }

        System.out.println(count);
        System.out.println(sb);
    }
}
