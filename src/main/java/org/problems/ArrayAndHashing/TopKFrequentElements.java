package org.problems.ArrayAndHashing;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] numbers = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequentEleWithNormal(numbers, k)));
    }
    private static int[] topKFrequentEle(int[] numbers, int k){

        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )).entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private static int[] topKFrequentEleWithNormal(int[] numbers, int k) {

        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : numbers) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert map entries to a list
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

        // Step 3: Sort by frequency (descending)
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        // Step 4: Extract top K keys
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(i).getKey();
        }

        return result;
    }

}
