package leetcode.cn;

public class Q1031 {
    /**
     * 0 1 2 3 4
     * 0 1 2 3 4  5
     * 0 1 3 6 10 15
     * i to j (included) prefix[j+1]-prefix[i]
     * i: [0, length - 1]
     */
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        // firstLen 在前面
        // 0~firstlen-1 开始
        return Math.max(f(prefix, firstLen, secondLen), f(prefix, secondLen, firstLen));
    }

    public int f(int[] prefix, int l1, int l2) {
        int tmp1 = 0, tmp2 = 0;
        // tmp1 记录在前面的那一个
        for (int i = l1; i + l2 < prefix.length; i++) {
            tmp1 = Math.max(tmp1, prefix[i] - prefix[i - l1]);
            tmp2 = Math.max(tmp2, tmp1 + prefix[i + l2] - prefix[i]);
        }
        return tmp2;
    }

}
