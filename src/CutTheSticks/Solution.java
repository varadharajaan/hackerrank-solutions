package CutTheSticks;

/**
 * @author Varadharajan on 2019-09-28 21:17
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {

        ArrayList<Integer> tmp = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length) {
            tmp.add(arr.length - i);
            i++;
            while (i < arr.length) {
                if (arr[i] == arr[i - 1]) {
                    i++;
                } else {
                    break;
                }
            }
        }
        int[] r = new int[tmp.size()];
        for (int j = 0; j < tmp.size(); j++) {
            r[j] = tmp.get(j);
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

