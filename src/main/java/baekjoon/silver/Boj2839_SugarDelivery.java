package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2839_SugarDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());

        int answer = -1;

        for (int fiveCount = n / 5; fiveCount >= 0; fiveCount--) {
            int weight = n - 5 * fiveCount;

            if (weight % 3 == 0) {
                answer = fiveCount + weight / 3;
                break;
            }
        }

        System.out.println(answer);
    }
}
