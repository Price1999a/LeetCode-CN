package leetcode.cn;

import java.util.HashMap;

public class Q982 {
    public static void main(String[] a) {
        int[] nums = {2, 1, 3};
        System.out.println(new SolutionFor982().countTriplets(nums));
    }
}

class SolutionFor982 {
    public int countTriplets(int[] nums) {
        int ret = 0;
        HashMap<Integer, Integer> cache = new HashMap<>(nums.length * nums.length);
        for (int i : nums)
            for (int j : nums) {
                int index = i & j;
                cache.put(index, cache.getOrDefault(index, 0)+1);
            }
        for (int c : cache.keySet())
            for (int i : nums) {
                if ((c & i) == 0)
                    ret += cache.get(c);
            }
        return ret;
    }
}