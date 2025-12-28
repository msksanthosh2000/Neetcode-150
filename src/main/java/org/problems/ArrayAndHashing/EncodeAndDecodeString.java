package org.problems.ArrayAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeString {
    public static void main(String[] args) {
        String[] s = {"hello", "world"};

        System.out.println(encode(s));
        String encoded = encode(s);
        System.out.println(decode(encoded));
    }

    private static String encode(String[] strings) {

        StringBuilder encodedString = new StringBuilder();

        for (String s : strings) {

            encodedString
                    .append(s.length())
                    .append("#")
                    .append(s);
        }

        return encodedString.toString();
    }

    private static List<String> decode(String s){

        List<String> decodedStrings = new ArrayList<>();

        int index =0;

        while(index < s.length()){

            int hashIndex = s.indexOf("#", index);

            int length = Integer.parseInt(s.substring(index, hashIndex));

            int start = hashIndex + 1;
            int end = start + length;

            decodedStrings.add(s.substring(start, end));

            index = end;
        }

        return decodedStrings;
    }
}
