package src.com.pack.greedy;

import java.util.Arrays;
import java.util.Comparator;


public class knapsackProblem {

	public static void main(String[] args) {
		
        int[] wt = {10, 40, 20, 30}; 
        int[] val = {60, 40, 100, 120}; 
        int capacity = 50;	
        
        double maxValue = getMaxValue(wt,val,capacity);
        System.out.println("Maximum Profit : "+maxValue);

	}

	private static double getMaxValue(int[] wt, int[] val, int capacity) {
		
		ItemValue[] ival = new ItemValue[wt.length];
		for(int i=0;i<wt.length;i++) {
			ival[i] = new ItemValue(wt[i],val[i],i);
		}
		
		Arrays.sort(ival,new Comparator<ItemValue>(){

			@Override
			public int compare(ItemValue o1, ItemValue o2) {
				
				return o2.cost.compareTo(o1.cost);
			}
			
		});
		
		double profit = 0;
		
		for(ItemValue i : ival) {
			
			int curWt= i.wt;
			int curVal = i.val;
			System.out.println(" cost :"+i.cost +" curWt :" +curWt +" curVal : "+curVal);
			
			if(capacity-curWt>=0) {
				capacity = capacity-curWt;
				profit+=curVal;
			}else {
				double fraction = (double)capacity/(double)curWt;
				profit+=curVal*fraction;
				capacity = (int)(capacity-(fraction*curWt));
				break;
			}	
		}
		
		return profit;
	}

}


class ItemValue{

	Double cost;
	int index;
	int wt;
	int val;
	
	public ItemValue(int wt, int val, int index) {
	
		this.wt = wt;
		this.val =val;
		this.index = index;
		cost = new Double(val/wt);
		
	}
}



