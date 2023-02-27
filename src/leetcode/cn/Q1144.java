package leetcode.cn;

public class Q1144 {
    public static void main(String[] a) {
        int[] input = new int[]{9, 6, 1, 6, 2};
        System.out.println(new SolutionFor1144().movesToMakeZigzag(input));
    }
}

class SolutionFor1144 {
    public int movesToMakeZigzag(int[] nums) {
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i != 0 ? nums[i - 1] : Integer.MAX_VALUE;
            int right = i != nums.length - 1 ? nums[i + 1] : Integer.MAX_VALUE;
            ret[i % 2] += Math.max(nums[i] - Math.min(left, right) + 1, 0);
        }

        return Math.min(ret[0], ret[1]);
    }
}