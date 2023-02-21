package leetcode.cn;

public class Q1326 {
    public static void main(String[] a) {
        int[] ranges = new int[]{3, 4, 1, 1, 0, 0};
        System.out.println(new Solution().minTaps(5, ranges));
    }
}

class Solution {
    public int minTaps(int n, int[] ranges) {
        int ret = 0;
        int[] rightest = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i >= ranges[i]) {
                rightest[i - ranges[i]] = i + ranges[i];
            } else {
                rightest[0] = Math.max(rightest[0], i + ranges[i]);
            }
        }
        int curRightest = 0;
        int nextRightest = 0;
        for (int i = 0; i < n; i++) {
            nextRightest = Math.max(nextRightest, rightest[i]);
            if (i == curRightest) {
                if (nextRightest <= curRightest) return -1;
                curRightest = nextRightest;
                ret++;
            }
        }

        return ret;
    }
}
