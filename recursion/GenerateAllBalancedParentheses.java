package src.main.java.org.example;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBalancedParentheses {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int n =3;
        int open =n, closed=n;
        list = solve(open, closed, "", list);
        list.forEach(System.out::println);
    }

    public static List<String> solve(int open, int closed, String output, List<String> list){
        if (open ==0 && closed==0) {
            list.add(output);
            return list;
        }

        if (open != 0) {
            String out1 = output;
            out1+="(";
            solve(open-1, closed, out1, list);
        }

        if (closed>open) {
            String out2=output;
            out2+=")";
            solve(open, closed-1, out2, list);
        }
        return list;
    }
}
