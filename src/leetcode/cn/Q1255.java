package leetcode.cn;

public class Q1255 {
}

class SolutionFor1255 {
    int res;
    String[] words;
    int[] score;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        res = 0;
        int[] wordCount = new int[26];
        for (char ch : letters) {
            wordCount[ch - 'a']++;
        }
        dfs(0, 0, wordCount);
        return res;
    }

    private void dfs(int index, int sumNow, int[] wordCount) {
        if (index >= words.length) {
            return;
        }
        int[] wordCountTmp = wordCount.clone();
        int sumThisWord = 0;
        char[] chars = words[index].toCharArray();
        for (char ch : chars) {
            if (wordCount[ch - 'a'] > 0) {
                sumThisWord = sumThisWord + score[ch - 'a'];
                wordCount[ch - 'a']--;
            } else {
                dfs(index + 1, sumNow, wordCountTmp);
                return;
            }
        }
        res = Math.max(res, sumNow + sumThisWord);
        dfs(index + 1, sumNow, wordCountTmp);
        dfs(index + 1, sumNow + sumThisWord, wordCount);
    }
}
