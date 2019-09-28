package kaprekarnumber;

/**
 * @author Varadharajan on 2019-09-28 22:37
 * @project name: hackrank_solutions
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {

        List<Long> numbers = new ArrayList<>();
        for (long i = p; i <= q; i++) {
            int digit = Long.toString(i).length();
            long square = i * i;
            String squareStr = Long.toString(square);
            String leftStr = squareStr.substring(0, squareStr.length() - digit);
            int left = (leftStr.isEmpty()) ? 0 : Integer.parseInt(leftStr);
            String rightStr = squareStr.substring(squareStr.length() - digit);
            int right = (rightStr.isEmpty()) ? 0 : Integer.parseInt(rightStr);
            if (left + right == i) {
                numbers.add(i);
            }
        }
        if (numbers.size() == 0) {
            System.out.println("INVALID RANGE");
        } else {
            for (long n : numbers) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}

