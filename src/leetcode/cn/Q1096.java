package leetcode.cn;

import java.util.*;

public class Q1096 {
    public static void main(String[] a) {
        System.out.println(new SolutionFor1096().braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
    }
}

class SolutionFor1096 {
    public List<String> braceExpansionII(String expression) {
        Set<String> res = new TreeSet<>();
        Queue<String> workList = new ArrayDeque<>();
        workList.offer(expression);

        while (!workList.isEmpty()) {
            String currentStr = workList.poll();
            int right = currentStr.indexOf('}');
            if (right == -1) {
                res.add(currentStr);
                continue;
            } else {
                int left = currentStr.lastIndexOf('{', right);
                String p = currentStr.substring(0, left), s = currentStr.substring(right + 1);
                String[] words = currentStr.substring(left + 1, right).split(",");
                for (String str : words)
                    workList.offer(p + str + s);
            }
        }

        List<String> ret = new ArrayList<>(res);
        return ret;
    }
}