package Lisaworkbook;

/**
 * @author Varadharajan on 2019-09-28 23:09
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {

        int counter = 0;
        int page = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr[i]; j = j + k) {
                int current = k;
                if (j + k - 1 > arr[i]) {
                    current = arr[i] % k;
                }
                if (j <= page && page < j + current) {
                    counter++;
                }
                page++;
            }
        }

        return counter;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

