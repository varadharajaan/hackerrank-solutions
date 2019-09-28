package AppendDelete;

/**
 * @author Varadharajan on 2019-09-28 21:09
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {

        if (k >= s.length() + t.length()) {
            return "Yes";
        }

        for (int i = s.length(); ; i--) {
            String prefixS = s.substring(0, i);
            if (t.startsWith(prefixS)) {
                int diff = (s.length() - i) + (t.length() - i);
                boolean value = diff <= k && (k - diff) % 2 == 0;
                if (value)
                    return "Yes";
                else
                    return "No";
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

