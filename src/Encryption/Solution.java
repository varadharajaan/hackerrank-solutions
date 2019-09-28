package Encryption;

/**
 * @author Varadharajan on 2019-09-28 22:27
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the encryption function below.
    static String encryption(String s) {
        StringBuilder sb = new StringBuilder();


        Double a = Math.sqrt(s.length());
        int h = (int) Math.floor(a);
        int w = (int) Math.ceil(a);
        int count = 0;
        char[] ar = s.toCharArray();

        for (int i = 0; i < w; i++) {
            int j = i;
            while (j < s.length()) {
                sb.append(ar[j]);
                j += w;
                count++;
            }
            sb.append(" ");

        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
