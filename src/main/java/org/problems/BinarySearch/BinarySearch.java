package org.problems.BinarySearch;

public class BinarySearch {


    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;

        System.out.println(binarySearch(nums, target));
    }

    private static int binarySearch(int[] nums, int target){

        int n = nums.length;
        int left = 0;
        int right = n-1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(target < nums[mid]){
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
         return -1;
    }
}
