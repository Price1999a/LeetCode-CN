package leetcode.cn;

import java.util.HashMap;
import java.util.Map;

public class Q2488 {
    public static void main(String[] a) {
        System.out.println(new SolutionFor2488().countSubarrays(new int[]{2, 3, 1}, 3));
    }
}


class SolutionFor2488 {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int kIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                kIndex = i;
                break;
            }
        }
        int ans = 0;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        counts.put(0, 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (Integer.compare(nums[i] - k, 0));
            if (i < kIndex) {
                counts.put(sum, counts.getOrDefault(sum, 0) + 1);
            } else {
                int prev0 = counts.getOrDefault(sum, 0);
                int prev1 = counts.getOrDefault(sum - 1, 0);
                ans += prev0 + prev1;
            }
        }
        return ans;
    }
}