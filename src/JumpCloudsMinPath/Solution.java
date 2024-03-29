package JumpCloudsMinPath;

/**
 * @author Varadharajan on 2019-09-28 21:23
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        class Pair {
            int p;
            int c;

            Pair(int p, int c) {
                this.p = p;
                this.c = c;
            }
        }
        int minPath = Integer.MAX_VALUE;
        LinkedList<Pair> stack = new LinkedList<>();
        stack.push(new Pair(0, 0));
        while (stack.size() != 0) {
            Pair pos = stack.pop();
            if (pos.p + 1 < c.length && c[pos.p + 1] != 1) {
                stack.push(new Pair(pos.p + 1, pos.c + 1));
            }
            if (pos.p + 2 < c.length && c[pos.p + 2] != 1) {
                stack.push(new Pair(pos.p + 2, pos.c + 1));
            }
            if (pos.p + 1 >= c.length) {
                minPath = Math.min(minPath, pos.c);
            }
        }
        return minPath;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
