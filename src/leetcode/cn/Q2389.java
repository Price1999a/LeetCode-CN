package leetcode.cn;

import java.util.Arrays;

public class Q2389 {
}


class SolutionFor2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] < nums[0]) {
                res[i] = 0;
            } else if (queries[i] >= nums[nums.length - 1]) {
                res[i] = nums.length;
            } else
                for (int j = 0; j < nums.length; j++)
                    if (queries[i] < nums[j]) {
                        res[i] = j;
                        break;
                    }
        }
        return res;
    }
}