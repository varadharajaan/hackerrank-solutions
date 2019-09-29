package ManasaStones;

/**
 * @author Varadharajan on 2019-09-29 10:11
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the stones function below.
    static int[] stones(int N, int A, int B) {

        List<Integer> list = new ArrayList<Integer>();

        if (A > B) {
            int temp = A;
            A = B;
            B = temp;
        }

        //Get min value of last stone (all A's)
        //There are N-1 gaps between stones
        int val = --N * A;

        //Calculate change in val per switch to B
        int dval = (B - A);

        //Print possible last stone values from smallest to largest
        //Avoid duplicate prints if A == B (dval == 0)
        list.add(val);
        if (dval > 0) {
            while (N-- > 0) {
                list.add(val += dval);
            }
        }
        int[] arr = new int[list.size()];
        int va = 0;
        for (int aa : list) {
            arr[va] = aa;
            va++;
        }

        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

