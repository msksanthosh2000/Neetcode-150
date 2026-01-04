package org.problems.BinarySearch;

public class FindMinRotatedSorted {
    public static void main(String[] args) {
        int[] numbers = {4,5,6,7,0,1,2};

        System.out.println(findMinRotatedSorted(numbers));
    }

    // Time : O(n log n)
    // Space : O(1)
    private static int findMinRotatedSorted(int[] numbers){

        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {

            int mid = left + (right - left) / 2;

            if(numbers[mid] > numbers[right]){
                left = mid + 1;
            } else{
                right = mid;
            }
        }

        return numbers[left];
    }
}
