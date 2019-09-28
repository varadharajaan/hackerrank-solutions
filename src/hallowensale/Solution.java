package hallowensale;

/**
 * @author Varadharajan on 2019-09-28 22:42
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        int counter = 0;
        int current = p;
        while (s >= current) {
            counter++;
            s -= current;
            if (current - d < m) {
                current = m;
            } else {
                current -= d;
            }
        }

        return counter;// Return the number of games you can buy

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

