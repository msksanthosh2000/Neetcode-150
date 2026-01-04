package org.problems.SlidingWindow;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(longestSubString(s));
    }

    private static int longestSubString(String s){

        int len = s.length();

        HashSet<Character> set = new HashSet<>();

        int start =0;
        int end = 0;
        int max_len = 0;
        int acc_start =0;

        while (end < len){
            while (set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            if((end - start) + 1 > max_len){
                max_len = (end - start) + 1;
                acc_start = start;

            }
            end++;

        }
        System.out.println(s.substring(acc_start, acc_start + max_len));
        return max_len;
    }
}
