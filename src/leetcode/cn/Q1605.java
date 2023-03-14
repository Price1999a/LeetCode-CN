package leetcode.cn;

public class Q1605 {
//    public static void main()
}

class SolutionFor1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ret = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++)
            for (int j = 0; j < colSum.length; j++) {
                int m = Math.min(rowSum[i], colSum[j]);
                ret[i][j] = m;
                rowSum[i] -= m;
                colSum[j] -= m;
            }
        return ret;
    }
}