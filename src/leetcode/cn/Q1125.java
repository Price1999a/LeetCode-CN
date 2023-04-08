package leetcode.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1125 {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        long all;
        int[] mask;
        long[][] mem;
        Map<String, Integer> sid = new HashMap<>(req_skills.length * 2);
        for (int i = 0; i < req_skills.length; i++) {
            sid.put(req_skills[i], i);
        }
        int n = people.size();
        mask = new int[n];
        for (int i = 0; i < n; i++)
            for (String s : people.get(i))
                mask[i] |= 1 << sid.get(s);

        int u = 1 << req_skills.length;
        mem = new long[n][u];
        for (int i = 0; i < n; i++)
            Arrays.fill(mem[i], -1); // -1 表示还没有计算过
        all = (1L << n) - 1;
        long res = dfs(n - 1, u - 1, mask, mem, all);
        int[] ans = new int[Long.bitCount(res)];
        for (int i = 0, j = 0; i < n; ++i)
            if (((res >> i) & 1) > 0)
                ans[j++] = i; // 所有在 res 中的下标
        return ans;
    }

    private long dfs(int i, int j, int[] mask, long[][] mem, long all) {
        if (j == 0) return 0;
        if (i < 0) return all;
        if (mem[i][j] != -1) return mem[i][j];
        long res = dfs(i - 1, j, mask, mem, all); // 不选 mask[i]
        long res2 = dfs(i - 1, j & ~mask[i], mask, mem, all) | (1L << i); // 选 mask[i]
        return mem[i][j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
    }

    class Solution {
        private long all;
        private int[] mask;
        private long[][] memo;

        public int[] smallestSufficientTeam(String[] reqSkills, List<List<String>> people) {
            var sid = new HashMap<String, Integer>();
            int m = reqSkills.length;
            for (int i = 0; i < m; ++i)
                sid.put(reqSkills[i], i); // 字符串映射到下标

            int n = people.size();
            mask = new int[n];
            for (int i = 0; i < n; ++i)
                for (var s : people.get(i)) // 把 people[i] 压缩成一个二进制数 mask[i]
                    mask[i] |= 1 << sid.get(s);

            int u = 1 << m;
            memo = new long[n][u];
            for (int i = 0; i < n; i++)
                Arrays.fill(memo[i], -1); // -1 表示还没有计算过
            all = (1L << n) - 1;
            long res = dfs(n - 1, u - 1);

            var ans = new int[Long.bitCount(res)];
            for (int i = 0, j = 0; i < n; ++i)
                if (((res >> i) & 1) > 0)
                    ans[j++] = i; // 所有在 res 中的下标
            return ans;
        }

        private long dfs(int i, int j) {
            if (j == 0) return 0; // 背包已装满
            if (i < 0) return all; // 没法装满背包，返回全集，这样下面比较集合大小会取更小的
            if (memo[i][j] != -1) return memo[i][j];
            long res = dfs(i - 1, j); // 不选 mask[i]
            long res2 = dfs(i - 1, j & ~mask[i]) | (1L << i); // 选 mask[i]
            return memo[i][j] = Long.bitCount(res) < Long.bitCount(res2) ? res : res2;
        }
    }

}
