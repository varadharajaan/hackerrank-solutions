package minimumdistance;

/**
 * @author Varadharajan on 2019-09-28 22:41
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

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int minDistance = Integer.MAX_VALUE;
        Map<Integer, Integer> value2lastIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if (value2lastIndex.containsKey(a[i])) {
                minDistance = Math.min(minDistance, i - value2lastIndex.get(a[i]));
            }

            value2lastIndex.put(a[i], i);
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

