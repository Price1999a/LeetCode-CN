package leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1042 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q1042().gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}})));
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
//        boolean[][] g = new boolean[n][n];
        List<Integer>[] g = new ArrayList[n];
//        Arrays.fill(g, new ArrayList<>(3));
        Arrays.setAll(g, e -> new ArrayList<>(3));
        for (int[] p : paths) {
            g[p[0] - 1].add(p[1] - 1);
            g[p[1] - 1].add(p[0] - 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            boolean[] used = new boolean[5];
            for (int index : g[i]) {
                used[ans[index]] = true;
            }
            for (int ii = 1; ii < 5; ii++) {
                if (!used[ii]) {
                    ans[i] = ii;
                    break;
                }
            }
        }

        return ans;
    }

}
