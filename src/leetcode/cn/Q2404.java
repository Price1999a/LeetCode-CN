package leetcode.cn;

import java.util.HashMap;
import java.util.Map;

public class Q2404 {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>(nums.length);
        for (int i : nums) {
            if (i % 2 == 0)
                cache.put(i, cache.getOrDefault(i, 0) + 1);
        }
        final int[] ans = {-1};
        final int[] count = {0};
        cache.forEach((k, v) -> {
            if (v > count[0]) {
                count[0] = v;
                ans[0] = k;
            } else if (v == count[0] && ans[0] > k) {
                ans[0] = k;
            }
        });
        return ans[0];
    }

}
