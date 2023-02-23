package leetcode.cn;

public class Q1140 {
    public static void main(String[] a) {
        int[] piles = new int[]{1, 2, 3, 4, 5, 100};
        System.out.println(new SolutionFor1140().stoneGameII(piles));
    }
}


class SolutionFor1140 {
    private int[] s;
    private Integer[][] f;
    private int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        s = new int[n + 1];
        f = new Integer[n][n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] + piles[i];
        }
        return dfs(1, 0);
    }

    public int dfs(int M, int i) {
        if (M * 2 >= n - i) {
            return s[n] - s[i];
        }
        if (f[i][M] != null) {
            return f[i][M];
        }
        int res = 0;
        for (int j = 1; j <= 2 * M; j++) {
            res = Math.max(res, s[n] - s[i] - dfs(Math.max(M, j), i + j));
        }
        f[i][M] = res;
        return res;
    }
}