package leetcode.cn;

public class QO47 {
    public static void main(String[] a) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().maxValue(grid));
    }
}

class Solution {
    public int maxValue(int[][] grid) {
        int l1 = grid.length, l2 = grid[0].length;
        int[][] tmp = new int[l1][l2];
//        int ret = 0;
        for (int i = 0; i < l1; i++)
            for (int j = 0; j < l2; j++) {
                int above = i == 0 ? 0 : tmp[i - 1][j],
                        left = j == 0 ? 0 : tmp[i][j - 1];
                tmp[i][j] = Math.max(above, left) + grid[i][j];
            }

        return tmp[l1 - 1][l2 - 1];
    }
}