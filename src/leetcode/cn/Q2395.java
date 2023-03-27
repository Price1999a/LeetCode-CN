package leetcode.cn;

import java.util.HashSet;
import java.util.Set;

public class Q2395 {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> cache = new HashSet<>(nums.length);
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i - 1] + nums[i];
            if (cache.contains(tmp)) return true;
            else cache.add(tmp);
        }
        return false;
    }

}
