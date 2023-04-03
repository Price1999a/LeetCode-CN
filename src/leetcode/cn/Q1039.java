package leetcode.cn;

public class Q1039 {
    public static void main(String[] args) {
        System.out.println(new Q1039().minScoreTriangulation(new int[]{1, 2, 3}));
    }

    public int minScoreTriangulation(int[] values) {
        Integer[][] mem = new Integer[values.length][values.length];
        dfs(0, values.length - 1, mem, values);
        return mem[0][values.length - 1];
    }

    private void dfs(int i, int j, Integer[][] mem, int[] values) {
        if (i + 1 >= j) {
            mem[i][j] = 0;
            return;
        }
        if (mem[i][j] != null) return;
        int ans = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            dfs(i, k, mem, values);
            dfs(k, j, mem, values);
            ans = Math.min(ans, mem[i][k] + mem[k][j] + values[i] * values[j] * values[k]);
        }
        mem[i][j] = ans;
    }
}

