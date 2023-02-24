package leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1238 {
    public static void main(String[] a) {
        System.out.println(Arrays.toString(new SolutionFor1238().circularPermutation(3, 2).toArray()));
    }
}

class SolutionFor1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        int len = 1 << n;
        boolean[] b = new boolean[len + 1];
        ans.add(start);
        b[start] = true;
        bt(ans, b, n, start, len);
        return ans;
    }

    private void bt(List<Integer> ans, boolean[] b, int n, int start, int len) {
        if (ans.size() == len) {
            b[len] = true;
        } else {
            for (int i = 0; i < n; i++) {
                int m = start ^ (1 << i);
                if (b[m]) continue;
                b[m] = true;
                ans.add(m);
                bt(ans, b, n, m, len);
                if (b[len]) return;
                b[m] = false;
                ans.remove(ans.size() - 1);
            }
        }
    }
}