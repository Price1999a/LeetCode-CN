package leetcode.cn;

public class Q831 {
    class Solution {
        public String maskPII(String s) {
            if (s.contains("@")) {
                String[] parts = s.toLowerCase().split("@");
                return parts[0].charAt(0) + "*****" + parts[0].charAt(parts[0].length() - 1) + "@" + parts[1];
            } else {
                StringBuilder stringBuilder = new StringBuilder(20);
                for (char ch : s.toCharArray()) {
                    if (ch <= '9' && ch >= '0') {
                        stringBuilder.append(ch);
                    }
                }
                if (stringBuilder.length() == 10) {
                    return "***-***-" + stringBuilder.substring(6);
                } else {
                    return "+" + "*".repeat(stringBuilder.length() - 10) + "-***-***-" + stringBuilder.substring(stringBuilder.length() - 4);
                }
//            return "";
            }
        }
    }

}
