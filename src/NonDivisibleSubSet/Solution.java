package NonDivisibleSubSet;

/**
 * @author Varadharajan on 2019-09-28 21:19
 * @project name: hackrank_solutions
 */

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here

        int[] arr = new int[s.size()];
        int val = 0;
        for (int aa : s) {
            arr[val] = aa;
            val++;
        }
        int[] remains = new int[k];
        for (int i = 0; i < arr.length; i++) {
            remains[arr[i] % k]++;
        }
        int result = 0;
        if (remains[0] > 0) {
            result++;
        }
        for (int i = 1; i < remains.length; i++) {
            if (i == (k - i)) {
                result++;
            } else {
                if (remains[i] >= remains[k - i]) {
                    result += remains[i];
                } else {
                    result += remains[k - i];
                }
                remains[i] = 0;
                remains[k - i] = 0;
            }
        }
        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

