package org.problems.TwoPointer;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
//        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

//        System.out.println(trap(height));
        System.out.println(trapOptimized(height));
    }

    // Time : O(n2)
    // Space: O(1)
    private static int trap(int[] height) {

        if (height.length < 2) return 0;

        int totalUnits = 0;

        for (int i = 1; i < height.length - 1; i++) {

            int leftMax = height[i];

            for (int j = 0; j < i; j++) {
                if (height[j] > leftMax) {
                    leftMax = height[j];
                }
            }

            int rightMax = height[i];

            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > rightMax) {
                    rightMax = height[j];
                }
            }

            int min = Math.min(rightMax, leftMax);

            totalUnits = totalUnits + (min - height[i]);

        }

        return totalUnits;
    }

    // Time : O(n)
    // Space : O(n)
    private static int trapOptimized(int[] height) {
        if (height.length < 2) return 0;

        int totalUnits = 0;
        Stack<Integer> rightMaxStack = new Stack<>();
        int leftMax = height[0];


        rightMaxStack.push(height[height.length - 1]);

        for (int i = height.length - 2; i >= 2; i--) {
            int temp = Math.max(rightMaxStack.peek(), height[i]);
            rightMaxStack.push(temp);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(rightMaxStack.peek(), leftMax);

            int units = min - height[i];
            totalUnits = totalUnits + Math.max(0,units);

            rightMaxStack.pop();
            leftMax = Math.max(leftMax, height[i]);
        }

        return totalUnits;
    }
}
