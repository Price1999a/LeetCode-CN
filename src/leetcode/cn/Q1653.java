package leetcode.cn;

public class Q1653 {
    public static void main(String[] a) {
        System.out.println(new SolutionFor1653().minimumDeletions("aababbab"));
    }
}


class SolutionFor1653 {
    public int minimumDeletions(String s) {
        int ret = s.length();
        char[] chars = s.toCharArray();
        int[] bBefore = new int[chars.length + 1], aAfter = new int[chars.length + 1];
        int tmp = 0;
        for (int i = 0; i < chars.length; i++) {
            bBefore[i] = tmp;
            if (chars[i] == 'b') tmp++;
        }
        tmp = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            aAfter[i] = tmp;
            if (chars[i] == 'a') tmp++;
        }
        for (int i = 0; i < chars.length; i++) {
            ret = Math.min(ret, bBefore[i] + aAfter[i]);
        }

        return ret;
    }
}