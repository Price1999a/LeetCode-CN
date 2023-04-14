package leetcode.cn;

import java.util.ArrayList;
import java.util.List;

public class Q1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>(queries.length);
        out:
        for (String q : queries) {
            int i = 0;
            for (char ch : q.toCharArray()) {
                if (i < pattern.length() && pattern.charAt(i) == ch) {
                    i++;
                } else if (Character.isUpperCase(ch)) {
                    ans.add(false);
                    continue out;
                }
            }
            if (i == pattern.length()) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }

}
