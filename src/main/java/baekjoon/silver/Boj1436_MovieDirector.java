package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1436_MovieDirector {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int val = 666;
        int count = 0;

        int n = Integer.parseInt(input.readLine());

        while (count < n) {
            if (String.valueOf(val).contains("666")) {
                count++;
            }

            if (count == n) break;

            val++;
        }

        System.out.println(val);
    }
}
