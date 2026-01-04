package org.problems.ArrayAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] numbers = {100,4,200,1,3,2};
//        int[] numbers = {0,3,7,2,5,8,4,6,0,1};

        System.out.println(longConsecutiveApp2(numbers));
    }

    // Time : O(n)
    // Space : O(n)
    private static int longConsecutiveApp2(int[] numbers){

        int longestLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int num : numbers){
            map.put(num, Boolean.FALSE);
        }

        for (int num : numbers){

            int currentLength = 1;

            // check in forward direction
            int nextNum = num + 1;
            while(map.containsKey(nextNum) && map.get(nextNum) == false){
                currentLength++;
                map.put(nextNum, Boolean.TRUE);

                nextNum++;
            }

            int prevNum = num -1;
            while (map.containsKey(prevNum) && map.get(prevNum) == false){
                currentLength++;
                map.put(prevNum, Boolean.TRUE);

                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }
        return longestLength;
    }

    private static int longConsecutiveApp1(int[] numbers){

        int max = 1;
        int count = 1;

        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length; i++) {

            if (numbers[i] == numbers[i - 1]) {
                // skip duplicates
                continue;
            }

            if(numbers[i] == numbers[i - 1] + 1){
                count++;
            } else {
                max = Math.max(count, max);
                count = 1;
            }

        }
        return Math.max(count, max);
    }



}
