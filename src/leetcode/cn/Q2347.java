package leetcode.cn;

import java.util.Arrays;

public class Q2347 {

    public static void main(String[] args) {
        int[] ranks = new int[]{13, 2, 3, 1, 9};
        char[] suits = new char[]{'a', 'a', 'a', 'a', 'a'};
        System.out.println(new SolutionFor2347().bestHand(ranks, suits));
    }
}

class SolutionFor2347 {
    public String bestHand(int[] ranks, char[] suits) {
        if (suits[0] == suits[1] && suits[0] == suits[2] && suits[0] == suits[3] && suits[0] == suits[4])
            return "Flush";
        Arrays.sort(ranks);
        if (ranks[0] == ranks[2] || ranks[1] == ranks[3] || ranks[2] == ranks[4]) return "Three of a Kind";
        if (ranks[0] == ranks[1] || ranks[1] == ranks[2] || ranks[2] == ranks[3] || ranks[3] == ranks[4]) return "Pair";
        return "High Card";
    }
}