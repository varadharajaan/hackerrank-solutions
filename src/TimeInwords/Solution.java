package TimeInwords;

/**
 * @author Varadharajan on 2019-09-28 22:47
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static final String[] DIGIT_WORDS = {"zero", "one", "two", "three",
            "four", "five", "six", "seven", "eight", "nine"};
    static final String[] TEEN_WORDS = {"ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen"};
    static final String[] TEN_WORDS = {null, "ten", "twenty", "thirty",
            "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the timeInWords function below.
    static String timeInWords(int H, int M) {
        String time;
        if (M == 0) {
            time = toWords(H) + " o' clock";
        } else if (M == 1) {
            time = "one minute past " + toWords(H);
        } else if (M == 15) {
            time = "quarter past " + toWords(H);
        } else if (M < 30) {
            time = toWords(M) + " minutes past " + toWords(H);
        } else if (M == 30) {
            time = "half past " + toWords(H);
        } else if (M == 45) {
            time = "quarter to " + toWords(H + 1);
        } else if (M == 59) {
            time = "one minute to " + toWords(H + 1);
        } else {
            time = toWords(60 - M) + " minutes to " + toWords(H + 1);
        }
        return time;

    }

    static String toWords(int number) {
        if (number >= 10 && number < 20) {
            return TEEN_WORDS[number - 10];
        } else if (number < 10) {
            return DIGIT_WORDS[number];
        } else if (number % 10 == 0) {
            return TEN_WORDS[number / 10];
        } else {
            return TEN_WORDS[number / 10] + " " + DIGIT_WORDS[number % 10];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

