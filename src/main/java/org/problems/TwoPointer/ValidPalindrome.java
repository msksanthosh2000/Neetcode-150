package org.problems.TwoPointer;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(s));
    }

    private static boolean isValidPalindrome(String s){

        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.toLowerCase();

        int left = 0;
        int right = s.length() -1;

        while(left < right){

            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
