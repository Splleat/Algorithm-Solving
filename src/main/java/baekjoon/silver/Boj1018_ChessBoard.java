package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1018_ChessBoard {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        String param = input.readLine();

        String[] parts = param.split(" ");

        int m = Integer.parseInt(parts[0].trim());
        int n = Integer.parseInt(parts[1].trim());

        char[][] board = new char[m][n];

        for (int i = 0; i < m; i++) {
            String board_row = input.readLine();

            board[i] = board_row.toCharArray();
        }

        System.out.println(countMinColorChanges(board, m, n));
    }

    private static int countMinColorChanges(char[][] board, int m, int n) {

        int minChange = Integer.MAX_VALUE;

        int row_cnt = m - 8;
        int col_cnt = n - 8;

        for (int i = 0; i <= row_cnt; i++) {
            for (int j = 0; j <= col_cnt; j++) {
                int currentChange = Math.min(countColorChanges(board, i, j), 64 - countColorChanges(board, i, j));
                minChange = Math.min(minChange, currentChange);
            }
        }

        return minChange;
    }

    private static int countColorChanges(char[][] board, int startRow, int startCol) {
        char[][] type = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
        int sum = 0;

        int idx = 0;

        for (int i = startRow; i < 8 + startRow; i++) {
            char[] current_type = type[idx++ % 2];

            for (int j = startCol; j < 8 + startCol; j++) {
                if (board[i][j] != current_type[j - startCol]) {
                    sum++;
                }
            }
        }

        return sum;
    }
}