package happyladybugs;

/**
 * @author Varadharajan on 2019-09-29 11:36
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {

        boolean hasEmpty = false;
        boolean hasUnhappy = false;
        Map<Character, Integer> color2count = new HashMap<Character, Integer>();

        for (int i = 0; i < b.length(); i++) {
            char cell = b.charAt(i);
            if (cell == '_') {
                hasEmpty = true;
            } else {
                if ((i == 0 || b.charAt(i - 1) != cell) && (i == b.length() - 1 || b.charAt(i + 1) != cell)) {
                    hasUnhappy = true;
                }

                if (!color2count.containsKey(cell)) {
                    color2count.put(cell, 0);
                }
                color2count.put(cell, color2count.get(cell) + 1);
            }
        }

        boolean flag = !hasUnhappy || (hasEmpty && color2count.values().stream().mapToInt(x -> x).min().getAsInt() >= 2);

        if (flag)
            return "YES";
        else
            return "NO";

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

