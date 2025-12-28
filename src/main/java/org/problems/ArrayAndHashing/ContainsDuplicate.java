package org.problems.ArrayAndHashing;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println("Using HashSet :" + containsDuplicateApproach1(nums));

        System.out.println("In Sorted Array :" + containsDuplicateApproach2(nums));
    }


    // Time : O(n)
    // Space : O(n)
    private static boolean containsDuplicateApproach1(int[] numbers){

        if(numbers.length <= 0){
            return false;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int num: numbers){

             if(set.contains(num)){
                 return true;
             } else {
                 set.add(num);
             }
        }

        return false;
    }



    /*
        Use when the Array is sorted
     */
    private static boolean containsDuplicateApproach2(int[] numbers) {

        if(numbers.length <= 0){
            return false;
        }

        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] == numbers[i-1]){
                return true;
            }
        }
        return false;
    }
}
