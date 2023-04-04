package leetcode.cn;

public class Q1000 {
    public static void main(String[] args) {
        System.out.println(new Q1000().mergeStones(new int[]{3, 5, 1, 2, 6}, 3));
    }

    Integer[][][] mem;
    int[] stones;
    int[][] sum;
    int k;

    public int mergeStones(int[] stones, int k) {
        if ((stones.length - 1) % (k - 1) == 0) {
            mem = new Integer[stones.length][stones.length][k + 1];
            sum = new int[stones.length][stones.length];
            for (int i = 0; i < stones.length; i++) {
                sum[i][i] = stones[i];
                for (int j = i + 1; j < stones.length; j++)
                    sum[i][j] = stones[j] + sum[i][j - 1];
            }
            this.stones = stones;
            this.k = k;
            dfs(0, stones.length - 1, 1);
            return mem[0][stones.length - 1][1];
        } else return -1;
    }

    private void dfs(int i, int j, int k1) {
        if (mem[i][j][k] != null) return;
        if (k1 == 1) {
            if (i == j) {
                mem[i][j][1] = 0;
            } else {
                dfs(i, j, k);
                mem[i][j][1] = mem[i][j][k] + sum[i][j];
                return;
            }
        } else {
            int tmp = Integer.MAX_VALUE / 2 - 2;
            for (int ii = i; ii < j; ii += (k - 1)) {
                dfs(i, ii, 1);
                dfs(ii + 1, j, k1 - 1);
                tmp = Math.min(tmp, mem[i][ii][1] + mem[ii + 1][j][k1 - 1]);
            }
            mem[i][j][k1] = tmp;
        }
    }
}
