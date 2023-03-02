package leetcode.cn;

public class Q0502 {
}

class SolutionFor0502 {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while (sb.length() < 32 && num != 0) {
            num *= 2;
            sb.append(num >= 1 ? '1' : '0');
            num -= num >= 1 ? 1 : 0;
        }
        return num != 0 ? "ERROR" : sb.toString();
    }
}