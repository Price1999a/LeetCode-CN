package leetcode.cn;

import java.util.Arrays;

public class Q2357 {
    public static void main(String[] a) {
        int[] nums = new int[]{1, 5, 0, 3, 5};
        System.out.println(new SolutionFor2357().minimumOperations(nums));
    }
}

class SolutionFor2357 {
    public int minimumOperations(int[] nums) {
        return (int) Arrays.stream(nums).filter(i -> i > 0).distinct().count();
    }
}
