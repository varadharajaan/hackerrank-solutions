package RepeatString;

/**
 * @author Varadharajan on 2019-09-28 21:20
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long counter = 0;
        if (s.length() > n) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == 'a') {
                    counter++;
                }
            }
            return counter;
        }
        long as = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                as++;
            }
        }

        long maxSeq = n / s.length();
        counter = maxSeq * as;
        int remaining = (int) (n - maxSeq * s.length());
        for (int i = 0; i < remaining; i++) {
            if (s.charAt(i) == 'a') {
                counter++;
            }
        }

        return counter;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

