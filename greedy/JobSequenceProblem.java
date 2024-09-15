package src.com.pack.greedy;

import java.util.ArrayList;
import java.util.List;

public class JobSequenceProblem {

	public static void main(String[] args) {
		
		List<Job> arr = new ArrayList<Job>();
	    arr.add(new Job('a', 2, 100));  
	    arr.add(new Job('b', 1, 19));  
	    arr.add(new Job('c', 2, 27));  
	    arr.add(new Job('d', 1, 25));  
	    arr.add(new Job('e', 3, 15));  
	      
	    sortJobByProfit(arr);
	    
	    
	    System.out.println("Following is maximum " + 
	                       "profit sequence of jobs :");
	    
	    printJobsequence(arr,3);
	    

	}

	private static void printJobsequence(List<Job> arr, int slot) {
		
	    boolean result[] = new boolean[slot]; 
	    char job[] = new char[slot]; 
		
	    for(int i=0;i<arr.size();i++) {
	    	
	    	for(int j = Math.min(slot-1, arr.get(i).deadline-1);j>=0;j--) {
	    		
	    		if (result[j] == false) 
	            { 
	                result[j] = true; 
	                job[j] = arr.get(i).id; 
	                break; 
	            }   		
	    	}
	    	
	    }
	    
	    for(char jb: job) 
	    { 
	       System.out.print(jb + "->"); 
	    } 
		
	}

	private static void sortJobByProfit(List<Job> arr) {
		
		int n = arr.size();
		for(int i=0;i<n;i++) {
			
			for(int j=1;j<n-i-1;j++) {
				
				if(arr.get(j).profit<arr.get(j+1).profit) {
					Job temp = arr.get(j);	
					arr.set(j, arr.get(j+1));
					arr.set(j + 1, temp); 
				}
			}
		}
	}
	
	

}

class Job{
	char id;  
	int deadline, profit;  
 
	public Job(){ } 
	  
	public Job(char id, int deadline, int profit)  
	{  
	    this.id = id;  
	    this.deadline = deadline;  
	    this.profit = profit;  
	} 
	 
}
