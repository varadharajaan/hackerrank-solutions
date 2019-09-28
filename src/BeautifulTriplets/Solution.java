package BeautifulTriplets;

/**
 * @author Varadharajan on 2019-09-28 22:39
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        final List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (list.contains(arr[i] + d) && list.contains(arr[i] + d + d)) {
                count++;
            }
        }

        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

