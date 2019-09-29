package fairrations;

/**
 * @author Varadharajan on 2019-09-28 23:18
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the fairRations function below.
    static String fairRations(int[] B) {
        int sum = 0;
        for (int i = 0; i < B.length; i++) {
            sum += B[i];
        }
        if (sum % 2 != 0) {
            return "NO";
        }
        int counter = 0;
        for (int i = 0; i < B.length - 1; i++) {
            if (B[i] % 2 != 0) {
                B[i]++;
                B[i + 1]++;
                counter += 2;
            }
        }
        return String.valueOf(counter);

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        String result = fairRations(B);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
