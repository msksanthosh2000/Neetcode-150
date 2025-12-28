package org.problems.ArrayAndHashing;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    private static int[] productExceptSelf(int[] nums){

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];


        left[0] =1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length-1] = 1;
        for (int i = nums.length -2; i > -1; i--) {
            right[i] = right[i+1] * nums[i+1];
        }

        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    private static int[] productExceptSelf2(int[] nums) {

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product = product * nums[j];
                }
            }
            ans[i] = product;
        }
        return ans;
    }
}
