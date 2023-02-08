package leetcode.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1233 {
    public List<String> removeSubfolders(String[] folder) {
        String[] last = {"#"};
        List<String> ret = Arrays.stream(folder)
                .sorted()
                .filter(i -> {
                    if (i.indexOf(last[0]) == 0) {
                        return false;
                    } else {
                        last[0] = i + "/";          // 这里必须+/来表示目录中的分隔
                    }
                    return true;
                })
                .toList();
        return ret;
    }

    public static void main(String[] args) {
        String[] folder = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        Q1233 q = new Q1233();
        System.out.println(q.removeSubfolders(folder));
    }
}
