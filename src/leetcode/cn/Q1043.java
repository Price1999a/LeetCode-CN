package leetcode.cn;

public class Q1043 {
    public static void main(String[] args) {
        System.out.println(new Q1043().maxSumAfterPartitioning(new int[]{4,7,5}, 2));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new int[arr.length + 1];
        f(0, arr, k);
        return dp[0];
    }

    private int[] dp;

    private int f(int i, int[] arr, int limit) {
//        if(dp[i]!=0)
        if (i >= arr.length) {
            return 0;
        } else if (i == arr.length - 1) {
            dp[i] = arr[i];
            return 0;
        } else {
            int maxTmp = arr[i];
            int dpTmp;
            if (dp[i + 1] == 0) {
                f(i + 1, arr, limit);
            }
            dpTmp = dp[i + 1] + maxTmp;
            for (int k = 1; k < limit && i + k  < arr.length; k++) {
                maxTmp = Math.max(maxTmp, arr[k + i]);
                if (dp[k + i + 1] == 0) {
                    f(i + k + i, arr, limit);
                }
                dpTmp = Math.max(dp[i + k + 1] + maxTmp * (k + 1), dpTmp);
            }
            dp[i] = dpTmp;
            return 0;
        }
    }
}
