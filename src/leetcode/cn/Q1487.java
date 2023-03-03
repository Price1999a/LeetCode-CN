package leetcode.cn;

import java.util.*;

public class Q1487 {
    public static void main(String[] a) {
        String[] names = new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"};
        System.out.println(Arrays.toString(new SolutionFor1487().getFolderNames(names)));
    }
}

class SolutionFor1487 {
    //    public String[] getFolderNames(String[] names) {
//        String[] ret = new String[names.length];
//        Set<String> cache = new HashSet<>(names.length);
//        for (int i = 0; i < names.length; i++) {
//            if (cache.add(names[i])) {
//                ret[i] = names[i];
//            } else {
//                int k = 1;
//                while (!cache.add(names[i] + "(" + k + ")")) {
//                    k++;
//                }
//                ret[i] = names[i] + "(" + k + ")";
//            }
//        }
//        return ret;
//    }
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> d = new HashMap<>();
        for (int i = 0; i < names.length; ++i) {
            if (d.containsKey(names[i])) {
                int k = d.get(names[i]);
                while (d.containsKey(names[i] + "(" + k + ")")) {
                    ++k;
                }
                d.put(names[i], k);
                names[i] += "(" + k + ")";
            }
            d.put(names[i], 1);
        }
        return names;
    }
}