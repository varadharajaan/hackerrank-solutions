package PickingNumbers;

/**
 * @author Varadharajan on 2019-09-28 20:16
 * @project name: hackrank_solutions
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    static final int LIMIT = 100;
    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> aa) {
        // Write your code here

        int[] a = new int[aa.size()];
        int val=0;
        for(Integer in : aa) {
            a[val]=in;
            val++;
        }
        int[] counts = new int[LIMIT];
        for (int number : a) {
            counts[number]++;
        }

        int result = Arrays.stream(counts).max().getAsInt();
        for (int i = 0; i + 1 < counts.length; i++) {
            result = Math.max(result, counts[i] + counts[i + 1]);
        }
        return result;

    }

}
 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

