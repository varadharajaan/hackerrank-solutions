package surface3d;

/**
 * @author Varadharajan on 2019-09-29 11:54
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static final int[] R_OFFSETS = {-1, 0, 1, 0};
    static final int[] C_OFFSETS = {0, 1, 0, -1};
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] heights) {

        int row = heights.length;
        int col = heights[0].length;

        int surface = row * col * 2;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int i = 0; i < R_OFFSETS.length; i++) {
                    int adjR = r + R_OFFSETS[i];
                    int adjC = c + C_OFFSETS[i];

                    int adjHeight = (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col) ? heights[adjR][adjC] : 0;
                    surface += Math.max(0, heights[r][c] - adjHeight);
                }
            }
        }
        return surface;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

