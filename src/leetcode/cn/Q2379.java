package leetcode.cn;

public class Q2379 {
    public static void main(String[] a) {
        System.out.println(new SolutionFor2379().minimumRecolors("WBWBBBW", 2));
    }
}

class SolutionFor2379 {
    public int minimumRecolors(String blocks, int k) {
        int ret = blocks.length();
        // k 是这里滑动窗口的长度 需要一个变量维护窗口内的W的数量
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += (blocks.charAt(i) == 'W') ? 1 : 0;
        }
        ret = count;
        for (int i = k; i < blocks.length(); i++) {
            char in = blocks.charAt(i), out = blocks.charAt(i - k);
            count += (in == 'W' ? 1 : 0) + (out == 'W' ? -1 : 0);
            ret = Math.min(count, ret);
        }

        return ret;
    }
}
