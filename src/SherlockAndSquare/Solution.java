package SherlockAndSquare;

/**
 * @author Varadharajan on 2019-09-28 21:12
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the squares function below.
    static int squares(int a, int b) {

        double min;
        double max;
        double minRoot;
        double maxRoot;
        int count = 0;

        min = a;
        max = b;
        minRoot = Math.sqrt(min);
        maxRoot = Math.sqrt(max);
        if ((int) minRoot != (int) maxRoot || minRoot == (int) minRoot
                || maxRoot == (int) maxRoot) {
            for (int j = (int) (Math.ceil(minRoot)); j <= maxRoot; j++) {
                count++;
            }
        } else {
            count = 0;
        }
        return count;


    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

