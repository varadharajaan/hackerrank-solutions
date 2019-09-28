package OrganizingContainer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solutionn {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {

        int n = container.length;
        int[] horizSums = new int[n];
        int[] vertSums = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                horizSums[i] += container[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vertSums[i] += container[j][i];
            }
        }
//         for (int i=0;i<n;i++) {
//             System.out.println(horizSums[i]);
//         }

//         for (int i=0;i<n;i++) {
//             System.out.println(vertSums[i]);
//         }

        Arrays.sort(horizSums);
        Arrays.sort(vertSums);

        for (int i = 0; i < n; i++) {
            if (horizSums[i] != vertSums[i]) {
                return "Impossible";
            }
        }

        return "Possible";

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
