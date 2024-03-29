package cavitymap;

/**
 * @author Varadharajan on 2019-09-28 23:21
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {

        ArrayList<Integer> x = new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length() - 1; j++) {
                Character c = grid[i].charAt(j);
                Character t = grid[i - 1].charAt(j);
                Character b = grid[i + 1].charAt(j);
                Character l = grid[i].charAt(j - 1);
                Character r = grid[i].charAt(j + 1);
                if (c > t && c > b && c > l && c > r) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        for (int i = 0; i < x.size(); i++) {
            grid[x.get(i)] =
                    grid[x.get(i)].substring(0, y.get(i)) +
                            "X" +
                            grid[x.get(i)].substring(y.get(i) + 1);
        }
        return grid;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

