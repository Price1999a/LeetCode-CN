package leetcode.cn;

public class Q2383 {
    /*
    输入：initialEnergy = 5, initialExperience = 3, energy = [1,4,3,2], experience = [
2,6,3,1]*/

    public static void main(String[] a) {
        System.out.println(new SolutionFor2383().minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1}));
    }
}

class SolutionFor2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ret = 0;
        for (int i = 0; i < energy.length; i++) {
            if (initialEnergy <= energy[i]) {
                ret += energy[i] - initialEnergy + 1;
                initialEnergy = energy[i] + 1;
            }
            if (initialExperience <= experience[i]) {
                ret += experience[i] - initialExperience + 1;
                initialExperience = experience[i] + 1;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return ret;
    }
}