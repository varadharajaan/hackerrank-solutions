package FindDigits;

/**
 * @author Varadharajan on 2019-09-28 21:04
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the findDigits function below.
    static int findDigits(int number) {
        int temp = number;
        int digits = 0;
        for (int j = 0; j < String.valueOf(number).length(); j++) {
            int currentDigit = temp % 10;
            if (currentDigit != 0 && number % currentDigit == 0) {
                digits++;
            }
            temp = temp / 10;
        }
        return digits;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

