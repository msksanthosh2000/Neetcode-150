package org.problems.SlidingWindow;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABCC";
        int k = 2;

        System.out.println(characterReplacement(s, k));
    }

    // Time : O(n)
    // Space : O(1)
    private static int characterReplacement(String s , int k){

        int[] freq = new int[26];
        int left =0;
        int max_freq = 0;
        int max_Window = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;

            max_freq = Math.max(max_freq, freq[s.charAt(right) - 'A']);

            int window = right - left + 1;

            if(window - max_freq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            window = right - left + 1;

            max_Window = Math.max(max_Window, window);
        }

        return max_Window;
    }
}
