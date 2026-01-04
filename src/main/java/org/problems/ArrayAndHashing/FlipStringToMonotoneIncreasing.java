package org.problems.ArrayAndHashing;

public class FlipStringToMonotoneIncreasing {

    public static void main(String[] args) {
        String s = "00011001";
        System.out.println(minFlipsMonoIncr(s));
    }

    private static int minFlipsMonoIncr(String s) {
        if(s.isEmpty()) return -1;

        int flips = 0;
        int ones = 0;

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '1'){
                ones++;
            } else {

                flips = Math.min(flips + 1, ones);
            }
        }

        return flips;
    }
}
