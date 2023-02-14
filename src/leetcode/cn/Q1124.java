package leetcode.cn;

import java.util.Map;
import java.util.TreeMap;

public class Q1124 {
    public static void main(String[] args) {
        int[] input = {9, 9, 6, 0, 6, 6, 9};
        System.out.println(new SolutionFor1124().longestWPI(input));
    }
}

class SolutionFor1124 {
    public int longestWPI(int[] hours) {
        int res = 0;
        int preSum = 0;
        int index = 0;
        Map<Integer, Integer> m = new TreeMap<>();
        for (var a : hours) {
            index++;
            preSum += a > 8 ? 1 : -1;
            if (preSum > 0) res = index;
            else {
                m.putIfAbsent(preSum, index - 1);
                Integer tmp = m.get(preSum - 1);
                if (tmp != null)
                    res = Math.max(res, index - 1 - tmp);
            }
        }

        return res;
    }
}
