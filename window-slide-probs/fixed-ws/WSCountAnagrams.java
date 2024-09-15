package src.com.pack.fixedws;

import java.util.HashMap;
import java.util.Map;

public class WSCountAnagrams {

    public static void main(String[] args) {

        String str = "aabaabaa";
        String ptr = "aaba";

        int result = getAnagrams(str,ptr);
        System.out.println("total anagrams present in the string is : "+result);

    }

    private static int getAnagrams(String str, String ptr) {

        int ans =0;
        int ws = ptr.length();

        if(str.length()<ptr.length()) return 0;

        Map<Character, Integer> map = new HashMap<>();
        for(char c : ptr.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();
        int i =0, j=0;

        while(j<str.length()){
            char c = str.charAt(j);

            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) counter--;
            }

            if(j-i+1<ws){
                j++;
            } else if(j-i+1==ws){
                if(counter==0){
                    ans++;
                }
                if(map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),map.get(str.charAt(i))+1);
                    if(map.get(str.charAt(i))==1) {
                        counter++;
                    }
                }
                i++;
                j++;
            }
        }

        return ans;
    }


}
