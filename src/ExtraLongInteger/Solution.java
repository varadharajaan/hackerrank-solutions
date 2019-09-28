package ExtraLongInteger;

/**
 * @author Varadharajan on 2019-09-28 21:06
 * @project name: hackrank_solutions
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int N) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= N; i++) {
            factorial = factorial.multiply(new BigInteger(i + ""));
        }
        System.out.println(factorial);

    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}

