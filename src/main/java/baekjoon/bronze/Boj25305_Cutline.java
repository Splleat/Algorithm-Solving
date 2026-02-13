package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj25305_Cutline {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = input.readLine().split(" ");

        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);

        String[] scoreInput = input.readLine().split(" ", n);

        int[] scoreArr = new int[n];

        for (int i = 0; i < n; i++) {
            scoreArr[i] = Integer.parseInt(scoreInput[i]);
        }

        Arrays.sort(scoreArr);

        System.out.println(scoreArr[scoreArr.length - k]);
    }
}
