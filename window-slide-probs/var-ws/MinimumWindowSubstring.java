package src.com.pack.varws;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args){

        String str = "ADOBECODEBANC";
        String ptr = "ABC";

        System.out.println(minWindow(str,ptr));

    }

    private static int minWindow(String str, String ptr) {
        int min =0;
        int i=0, j=0;

        if(str.length()<ptr.length()) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for(char c : ptr.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);

        }

        int counter = map.size();

        while(j<str.length()){
            char ch = str.charAt(j);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) {
                    counter--;
                }
            }

            if(counter==0){

                char ci = str.charAt(i);
                if(map.containsKey(ci)){

                    if(map.get(ci)<0){
                        i++;
                    }

                }

            }
            j++;
        }


        return min;
    }


}
