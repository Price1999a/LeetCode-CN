package leetcode.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1237 {
}

class CustomFunction {
    public int f(int x, int y) {
        return x + y;
    }
}

class SolutionFor1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            int f = customfunction.f(x, y);
            if (f == z) {
                res.add(new ArrayList<>(List.of(new Integer[]{x, y})));
                x++;
                y--;
            } else if (f > z)
                y--;
            else x++;
        }

        return res;
    }
}
