package leetcode.cn;

import java.util.Arrays;

public class Q1626 {

    public static void main(String[] a) {
        System.out.println(new Q1626().bestTeamScore(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1}));
    }


    public int bestTeamScore(int[] scores, int[] ages) {
        Integer[] pos = new Integer[scores.length];
        for (int i = 0; i < pos.length; i++)
            pos[i] = i;
        Arrays.sort(pos, (i1, i2) -> {
            if (ages[i1] == ages[i2]) return scores[i1] - scores[i2];
            else return ages[i1] - ages[i2];
        });
        int res = 0;
        int[] dp = new int[pos.length];
        for (int i = 0; i < pos.length; i++)
            dp[i] = scores[pos[i]];
        for (int i = 0; i < pos.length; i++) {
            for (int j = 0; j < i; j++) {
                if (scores[pos[i]] >= scores[pos[j]]) {
                    dp[i] = Math.max(dp[i], dp[j] + scores[pos[i]]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}


