package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2587_RepresentativeValue2 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int[] inputArr = new int[5];
        int sum = 0;

        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = Integer.parseInt(input.readLine());
            sum += inputArr[i];
        }

        Arrays.sort(inputArr);

        System.out.println(sum / inputArr.length);
        System.out.println(inputArr[inputArr.length / 2]);
    }
}
