package org.problems.TwoPointer;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(containerWithMostWater(height));
    }

    private static int containerWithMostWater(int[] height){

        if(height.length == 0) return 0;

        int max = 0;

        int left = 0;
        int right = height.length -1;

        while (left < right){

            int h = Math.min(height[left], height[right]);
            int area = right - left;

            int max_area = h * area;
            max = Math.max(max_area, max);

            if(height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
        }

        return max;
    }
}
