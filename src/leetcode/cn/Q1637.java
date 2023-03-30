package leetcode.cn;

import java.util.Arrays;

public class Q1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (i1, i2) -> i1[0] > i2[0] ? 1 : -1);
        int ret = 0;
        for (int i = 1; i < points.length; i++) {
            ret = Math.max(points[i][0] - points[i - 1][0], ret);
        }
        return ret;
    }

}
