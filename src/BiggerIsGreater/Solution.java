package BiggerIsGreater;

/**
 * @author Varadharajan on 2019-09-28 22:32
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String ww) {

        char[] w = ww.toCharArray();
// we need to replace some char from right with some on the left which is smaller than right char
        int len = w.length;

        for (int i = len - 2; i > -1; i--) {
            int swapIndex = -1;

            for (int j = i + 1; j < len; j++) {

                if (w[j] > w[i]) {
                    if (swapIndex > -1 && w[j] < w[swapIndex]) {
                        swapIndex = j;
                    } else if (swapIndex < 0) {
                        swapIndex = j;
                    }

                }
            }

            if (swapIndex > i) {
                char t = w[swapIndex];
                w[swapIndex] = w[i];
                w[i] = t;

                Arrays.sort(w, i + 1, len);
                return new String(w);
            }
        }

        return "no answer";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

