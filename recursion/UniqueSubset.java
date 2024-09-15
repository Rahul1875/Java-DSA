package src.main.java.org.example;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubset {

    public static void main(String[] args) {
        Set<String> uniqueSubset = new HashSet<>();
        uniqueSubset = printUnique("aab", "", uniqueSubset);
        System.out.println("Unique subsets: ");
        uniqueSubset.forEach(System.out::println);
    }


    public static Set<String> printUnique(String input, String output, Set<String> resMap) {
        if (input.isEmpty()) {
            resMap.add(output);
            return new HashSet<>();
        }

        String out1 = output;
        String out2 = output;
        out2+=input.charAt(0);

        input = input.substring(1);

        printUnique(input, out1, resMap);
        printUnique(input, out2, resMap);

        return resMap;

    }
}
