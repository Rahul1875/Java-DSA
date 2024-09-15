package src.com.pack.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordBreakProblem {

	static Set<String> dictionary = new HashSet<String>();
	static Map<String, Boolean> map = new HashMap<String, Boolean>();
	
	public static void main(String[] args) {
		
		String temp_dictionary[] = {"mobile","samsung","sam","sung",  
                "man","mango","icecream","and",  
                "go","i","like","ice","cream"}; 
		
		
		for(String word : temp_dictionary) {
			dictionary.add(word);
		}
		
		System.out.println(wordBreak("ilikesamsung")); 
        System.out.println(wordBreak("iiiiiiii")); 
        System.out.println(wordBreak("")); 
        System.out.println(wordBreak("ilikelikeimangoiii")); 
        System.out.println(wordBreak("samsungandmango")); 
        System.out.println(wordBreak("samsungandmangok"));
		
	}

	private static boolean wordBreak(String word) {
		
		int size = word.length();
		
		if(size==0) {
			return true;
		}
		
		if(map.containsKey(word)) {
			return map.get(word);
		}
		
		for(int i=1;i<=size;i++) {
			if(dictionary.contains(word.substring(0,i)) && wordBreak(word.substring(i))) {
				map.put(word, true);
				return true;
			}
		}	
		return false;
	}

}
