package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1181_SortingWords {
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
            while (compare(arr[left], pivot) < 0) left++;
            while (compare(arr[right], pivot) > 0) right--;

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

    static int compare(String str1, String str2) {
        if (str1 == null && str2 == null) return 0;
        if (str1 == null) return -1;
        if (str2 == null) return 1;

        if (str1.equals(str2)) return 0;

        if (str1.length() != str2.length()) {
            return str1.length() - str2.length();
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) - str2.charAt(i);
            }
        }

        return 0;
    }

    static class SimpleHashUtils {
        int dupCount = 0;

        void save(String[] arr, String value) {
            int len = arr.length;
            int hash = value.hashCode();
            int index = Math.abs(hash) % len;

            while (arr[index] != null) {
                if (value.equals(arr[index])) {
                    dupCount++;
                    return;
                }

                index++;

                if (index >= len) {
                    index -= len;
                }
            }

            arr[index] = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());

        String[] arr = new String[n];

        SimpleHashUtils utils = new SimpleHashUtils();

        for (int i = 0; i < n; i++) {
            String word = input.readLine();
            utils.save(arr, word);
        }

        quickSort(arr, 0, arr.length - 1);

        for (String val : arr) {
            if (val == null) continue;
            sb.append(val).append('\n');
        }

        System.out.println(sb);
    }
}
