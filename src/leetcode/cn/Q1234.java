package leetcode.cn;

import java.util.Arrays;

public class Q1234 {
    public static void main(String[] args) {
        SolutionFor1234 s = new SolutionFor1234();
        System.out.println(s.balancedString("RRRE"));
    }
}

class SolutionFor1234 {
    public int balancedString(String s) {
        int ret = s.length();
        int[] infos = new int['Z'];
        Arrays.fill(infos, 0);
        int target = ret / 4;
        char[] schars = s.toCharArray();
        for (char ch : schars) {
            infos[ch]++;
        }
        if (check(infos, target)) return 0;
        int leftPos = 0, rightPos = 0;
        while (rightPos < s.length()) {
            infos[schars[rightPos]]--;
            while (check(infos, target) && leftPos < s.length()) {
                ret = Math.min(ret, rightPos - leftPos + 1);
                infos[schars[leftPos]]++;
                leftPos++;
            }
            rightPos++;
        }
        return ret;
    }

    public boolean check(int[] cnt, int partial) {
        return cnt['Q'] <= partial && cnt['W'] <= partial && cnt['E'] <= partial && cnt['R'] <= partial;
    }

}