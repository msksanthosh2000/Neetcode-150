package org.problems.BinarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(searchInRotatedArray(numbers, target));
    }

    // Time	O(log n)
    // Space	O(1)
    private static int searchInRotatedArray(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right){
            
            int mid = left + (right-left) / 2;
            
            if(target == nums[mid]){
                return mid;
            }

            // left is sorted
            if (nums[mid] >= nums[left]) {

                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid -1;
                }
            }
        }

        return -1;
    }
}
