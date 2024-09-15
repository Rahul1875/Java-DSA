package src.com.pack.varws;

import java.util.HashMap;
import java.util.Map;

public class LargestSubStringWithKUniqueChar {

    public static void main(String[] args){

        String str = "aabacbebebe";
        int k =3;

        System.out.println(getLargestSubString(str,k));

    }

    private static int getLargestSubString(String str, int k) {

        int res =0;
        Map<Character,Integer> map = new HashMap<>();
        int i =0, j=0;

        while(j<str.length()){
            char ch = str.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);

            if(map.size()<k){
                j++;
            } else if(map.size()==k){
                res = Math.max(res,(j-i+1));
                j++;
            } else{
                while(map.size()>k){
                    char c = str.charAt(i);
                    map.put(c,map.get(c)-1);
                    i++;
                    if(map.get(c)==0){
                        map.remove(c);
                    }
                }
                j++;
            }
        }
        return res;
    }
}
