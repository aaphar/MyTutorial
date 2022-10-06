package algorithms;

import java.util.List;

public class HourglasSum {
    static int R = 6;
    static int C = 6;

    // Return maximum sum of
    // hour glass in ar[][]
    public static int hourglassSum(int[][] mat) {
        if (R < 3 || C < 3) {
            System.out.println("Not possible");
            System.exit(0);
        }

        // Here loop runs (R-3)*(C-3)
        // times considering different
        // top left cells of hour glasses.
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < R - 2; i++) { // yeni hemise sogda start pointden elave iki olmalidir
            for (int j = 0; j < C - 2; j++) {
                // Considering mat[i][j] as top
                // left cell of hour glass.
                int sum = (mat[i][j] + mat[i][j + 1] + mat[i][j + 2]) +
                        (mat[i + 1][j + 1]) +
                        (mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2]);

                // If previous sum is less than
                // current sum then update
                // new sum in max_sum
                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        if (R < 3 || C < 3) {
            System.out.println("Not possible");
            System.exit(0);
        }

        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < R - 2; i++) {
            for (int j = 0; j < C - 2; j++) {

                int sum = (arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)) +
                        (arr.get(i + 1).get(j + 1)) +
                        (arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2));

                max_sum = Math.max(max_sum, sum);
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {

    }
}
