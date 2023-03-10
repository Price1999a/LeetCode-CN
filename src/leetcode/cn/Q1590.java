package leetcode.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1590 {
    public static void main(String[] a) {
        System.out.println(new SolutionFor1590().minSubarray(new int[]{3, 1, 4, 2}, 6));
    }
}

class SolutionFor1590 {
    public int minSubarray(int[] nums, int p) {
        int numsLen = nums.length;
        int[] prefix = new int[numsLen + 1];
        for (int i = 0; i < numsLen; i++) {
            prefix[i + 1] = (prefix[i] + nums[i]) % p;
        }
        if (prefix[numsLen] == 0) return 0;
        Map<Integer, Integer> posCache = new HashMap<>();
        int ret = numsLen;
        for (int i = 0; i <= numsLen; i++) {
            posCache.put(prefix[i], i);
            int tmp = posCache.getOrDefault((prefix[i] - prefix[numsLen] + p) % p, -numsLen);
            ret = Math.min(i - tmp, ret);
        }

        return ret == numsLen ? -1 : ret;
    }
}