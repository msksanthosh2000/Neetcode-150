package org.problems.TwoPointer;

import java.util.Arrays;

public class TwoSumInSorted {

    public static void main(String[] args) {
        int[]  numbers = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    private static int[] twoSum(int[] nums, int target){

        int[] result = new int[2];
        int left = 0;
        int right = nums.length-1;

        while (left < right){

            int sum  = nums[left] + nums[right];

            if(target == sum){
                result[0] = left + 1;
                result[1] = right +1;
                return result;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}
