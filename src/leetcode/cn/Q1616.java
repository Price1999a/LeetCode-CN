package leetcode.cn;

public class Q1616 {
}

class SolutionFor1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        return checkDiff(a, b) || checkDiff(b, a);
    }

    public boolean checkDiff(String a, String b) {
        int p1 = 0, p2 = a.length() - 1;
        while (p1 < p2 && a.charAt(p1) == b.charAt(p2)) {
            p1++;
            p2--;
        }
        if (p1 >= p2) return true;
        else return checkSingle(a.substring(p1, p2 + 1)) || checkSingle(b.substring(p1, p2 + 1));
    }

    public boolean checkSingle(String a) {
        int p1 = 0, p2 = a.length() - 1;
        while (p1 < p2 && a.charAt(p1) == a.charAt(p2)) {
            p1++;
            p2--;
        }
        return p1 >= p2;
    }
}