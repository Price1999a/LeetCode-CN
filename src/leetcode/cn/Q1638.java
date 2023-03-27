package leetcode.cn;

public class Q1638 {

    public static void main(String[] a) {
        System.out.println(new Q1638().countSubstrings("aba", "baba"));
    }

    public int countSubstrings(String s, String t) {
        int ls = s.length(), lt = t.length();
        char[] chs = s.toCharArray(), cht = t.toCharArray();
        int res = 0;

        for (int i = 0; i < ls; i++) {
            for (int j = 0; j < lt; j++) {
                int diffCount = 0;
                for (int k = 0; k + i < ls && k + j < lt; k++) {
                    if (chs[i + k] != cht[j + k]) diffCount++;
                    if (diffCount <= 1) res += diffCount;
                    else break;
                }
            }
        }

        return res;
    }
}
