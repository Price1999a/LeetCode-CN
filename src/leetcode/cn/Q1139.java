package leetcode.cn;

public class Q1139 {
    public static void main(String[] a) {
        int[][] grid = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(new SolutionFor1139().largest1BorderedSquare(grid));
    }
}

class SolutionFor1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int ret = 0;
        int[][][] tmp = new int[grid.length][grid[0].length][2];
        // tmp[][][0] 左侧有多少连续1 [][][1] 上方有多少连续1

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        // 最上一行
                        tmp[i][j][1] = 1;
                    } else {
                        tmp[i][j][1] = tmp[i - 1][j][1] + 1;
                    }
                    if (j == 0) {
                        // 最右一行
                        tmp[i][j][0] = 1;
                    } else {
                        tmp[i][j][0] = tmp[i][j - 1][0] + 1;
                    }
                }
            }
        }
        int p;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                p = Math.min(tmp[i][j][0], tmp[i][j][1]);
                if (p > 0) {
                    for (int k = p; k > 0; k--) {
                        if (tmp[i + 1 - k][j][0] >= k && tmp[i][j + 1 - k][1] >= k) {
                            ret = Math.max(k * k, ret);
                            break;
                        }
                    }
                }
            }
        }

        return ret;
    }
}