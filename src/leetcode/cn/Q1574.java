package leetcode.cn;

public class Q1574 {
}

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i + 1 < n && arr[i] <= arr[i + 1]) {
            ++i;
        }
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) {
            --j;
        }
        // 首先找到了 整个数组两侧的非递归数组
        if (i >= j) {
            return 0;
        }
        // 假如两者有共同部分 那么就直接返回0（值得注意的是 这必然意味着 i==arr.length-1; j=0）
        int ans = Math.min(n - i - 1, j);
        for (int l = 0, r = j; l <= i; ++l) {
            while (r < n && arr[r] < arr[l]) {
                ++r;
            }
            ans = Math.min(ans, r - l - 1);
        }
        // 然后使用双指针来判断这里需要排除的中间区间长度（利用了两边已经得到的单调性）
        return ans;
    }
}
