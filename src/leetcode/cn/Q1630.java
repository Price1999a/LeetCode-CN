package leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1630 {
    public static void main(String[] a) {
        // * 输入：nums = [4,6,5,9,3,7], l = [0,0,2], r = [2,3,5]
        System.out.println(new Q1630().checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>(l.length);
        a1:
        for (int i = 0; i < l.length; i++) {
            int[] tmp = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(tmp);
            for (int j = 2; j < tmp.length; j++) {
                if (tmp[j - 1] - tmp[j - 2] != tmp[j] - tmp[j - 1]) {
                    res.add(false);
                    continue a1;
                }
            }
            res.add(true);
        }
        return res;
    }
}
