package org.problems.ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println(Arrays.toString(twoSumApproach1(nums, target)));
        System.out.println(Arrays.toString(twoSumApproach2(nums, target)));
    }

    // Time : O(n)
    // Space : O(1)
    private static int[] twoSumApproach1(int[] numbers, int target) {

        if (numbers.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    // TimeComplexity - O(n)
    // Space Complexity - O(n)
    private static int[] twoSumApproach2(int[] numbers, int target){
        if (numbers.length == 0) {
            return new int[]{-1, -1};
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int compliment = target - numbers[i];

            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
