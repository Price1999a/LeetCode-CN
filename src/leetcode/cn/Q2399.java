package leetcode.cn;

public class Q2399 {
    class Solution {
        public boolean checkDistances(String s, int[] distance) {
            int[] mydis = new int[26];
            char[] schars = s.toCharArray();
            for (int i = 0; i < schars.length; i++) {
                if (mydis[schars[i] - 'a'] == 0)
                    mydis[schars[i] - 'a'] = i;
                else
                    mydis[schars[i] - 'a'] = i - mydis[schars[i] - 'a'];
            }
//        boolean res = true;
            for (int i = 0; i < 26; i++) {
                if (mydis[i] != 0) {
                    if (mydis[i] != distance[i] + 1)
                        return false;
                }
            }
            return true;
        }
    }

}
