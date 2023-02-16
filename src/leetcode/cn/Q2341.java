package leetcode.cn;

import java.util.Arrays;

public class Q2341 {


    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 2, 1, 3, 2, 2};
        System.out.println(Arrays.toString(new Solution().numberOfPairs(ints)));
    }
}

class Solution {
    public int[] numberOfPairs(int[] nums) {
        boolean[] res = new boolean[101];
        Arrays.fill(res, false);
        for (var n : nums) {
            res[n] = !res[n];
        }
        int count = 0;
        for (var b : res) {
            count += b ? 1 : 0;
        }
        return new int[]{(nums.length - count) / 2, count};
    }
}