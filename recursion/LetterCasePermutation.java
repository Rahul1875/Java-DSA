package src.main.java.org.example;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public  static  void main(String[] ars) {
        String input = "a1B2";
        List<String> list = new ArrayList<>();
        list = solve(input, " ", list);
        list.forEach(System.out::println);
    }

    public static List<String> solve(String input, String output, List<String> list) {

        if (input.length() ==0) {
            list.add(output);
            return new ArrayList<>();
        }

        if (Character.isAlphabetic(input.charAt(0))) {
            String out1 = output;
            String out2 = output;

            out1 = out1+Character.toLowerCase(input.charAt(0));
            out2 = out2+Character.toUpperCase(input.charAt(0));

            input = input.substring(1);

            solve(input, out1, list);
            solve(input, out2, list);
        } else {
            String out1 = output;
            out1+=input.charAt(0);
            input = input.substring(1);
            solve(input, out1, list);
        }

        return list;
    }

}
