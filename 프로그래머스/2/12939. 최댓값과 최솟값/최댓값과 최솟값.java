import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        return min + " " + max;
    }
}