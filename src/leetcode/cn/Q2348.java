package leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2348 {
    public static void main(String[] args) {
        int n = 919;
        int[][] queries = {{0, 1}, {2, 2}, {0, 3}, {0, 6}};
        System.out.println(Arrays.toString(new SolutionFor2348().productQueries(n, queries)));
    }
}


class SolutionFor2348 {

    static final int mod = 10_0000_0000 + 7;

    public int[] productQueries(int n, int[][] queries) {
        char[] binary = new StringBuilder(Integer.toBinaryString(n))
                .reverse().toString()
                .toCharArray();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == '1') {
                a.add(i);
            }
        }
        Map<Integer, Integer> cache = new HashMap<>();
        ArrayList<Integer> ret = new ArrayList<>();
        for (var ints : queries) {
            int index = ints[0] * a.size() + ints[1];
            Integer tmp = cache.get(index);
            if (tmp == null) {
                long c = 1;
                for (int i = ints[0]; i <= ints[1]; i++) {
                    c = c << a.get(i);
                    c = c % mod;
                }
                cache.put(index, (int) c);
                tmp = (int) c;
            }
            ret.add(tmp);
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }
}
