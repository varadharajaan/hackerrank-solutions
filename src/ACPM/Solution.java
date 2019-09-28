package ACPM;

/**
 * @author Varadharajan on 2019-09-28 21:43
 * @project name: hackrank_solutions
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {

        int teamCount = 0, maxTopic = 0;
        int size = topic.length;

        BitSet[] bitset = new BitSet[size];
        for (int i = 0; i < size; i++) {
            BigInteger b1 = new BigInteger(topic[i], 2);
            bitset[i] = BitSet.valueOf(b1.toByteArray());
        }
        for (int i = 0; i < size - 1; i++) {
            BitSet bitset1 = bitset[i];
            for (int j = i + 1; j < size; j++) {
                BitSet bitset2 = bitset[j];
                BitSet tmpset = new BitSet();
                tmpset.or(bitset1);
                tmpset.or(bitset2);
                if (tmpset.cardinality() > maxTopic) {
                    maxTopic = tmpset.cardinality();
                    teamCount = 1;
                } else if (maxTopic == tmpset.cardinality()) {
                    teamCount++;
                }
            }

        }
        int[] result = {maxTopic, teamCount};
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

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

