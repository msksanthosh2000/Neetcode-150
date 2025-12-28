package org.problems.ArrayAndHashing;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {

        String s1 = "racecar";
        String s2 = "carrace";

        System.out.println(isAnagramBrute(s1,s2));
        System.out.println(isAnagram(s1, s2));
    }

    // Time : O(n log n)  - quick sort
    // Space : O(n)
    private static boolean isAnagramBrute(String s1, String s2){

        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);

        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);

        return Arrays.equals(c1,c2);
    }


    // Time : O(n)
    // Space : O(1)
    private static boolean isAnagram(String s1, String s2) {

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        //remove empty space
        s1 = s1.replace(" ", "");
        s2 = s2.replace(" ", "");

        if (s1.length() != s2.length()) {
            return false;
        }

        int[] counts = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;

        }


        for (int i = 0; i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;
        }

        for (int count : counts) {
            if(count !=0){
                return false;
            }
        }

        return true;
    }
}
