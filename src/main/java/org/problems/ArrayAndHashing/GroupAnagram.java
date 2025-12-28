package org.problems.ArrayAndHashing;

import java.sql.Array;
import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagram(strs));
    }


    // Time : O(n) + O(n log n)
    // Space : O(n)
    public static List<List<String>> groupAnagram(String[] strings)
    {
        if(strings.length == 0){
            new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s: strings){

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            map.computeIfAbsent(sortedKey, v -> new LinkedList<>()).add(s);

        }
        return new ArrayList<>(map.values());
    }
}
