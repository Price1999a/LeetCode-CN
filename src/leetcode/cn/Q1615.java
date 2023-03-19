package leetcode.cn;

public class Q1615 {
}

class SolutionFor1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] cnt = new int[n];
        for (int[] road : roads) {
            connected[road[0]][road[1]] = true;
            connected[road[1]][road[0]] = true;
            cnt[road[0]]++;
            cnt[road[1]]++;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ret = Math.max(ret, cnt[i] + cnt[j] - (connected[i][j] ? 1 : 0));
            }
        }
        return ret;
    }
}