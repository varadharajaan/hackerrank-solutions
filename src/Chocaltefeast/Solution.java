package Chocaltefeast;

/**
 * @author Varadharajan on 2019-09-28 22:49
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int N, int C, int M) {
        int count = N / C;
        int wrapperNum = count;
        while (wrapperNum >= M) {
            int exchangeNum = wrapperNum / M;
            count += exchangeNum;
            wrapperNum = exchangeNum + wrapperNum % M;
        }
        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

