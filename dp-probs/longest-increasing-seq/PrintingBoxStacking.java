package src.com.pack.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintingBoxStacking {

	public static void main(String[] args) {
		

		List<Box> boxes = Arrays.asList(new Box(4, 2, 1),
				new Box(5, 3, 2));	
		
		maxHeight(boxes);

	}
	
	private static void  maxHeight(List<Box> boxes) {
		
		
		// generate rotations of each box
		List<Box> rotations = createAllRotations(boxes);
		
		Collections.sort(rotations,(x,y)->(y.length * y.width - x.length * x.width));
		
		// max_height[i] stores the maximum possible height when i'th box is on the top
		int[] max_height = new int[rotations.size()];
		int[] result = new int[rotations.size()];
		
		
		for(int i=0;i<rotations.size();i++) {
			max_height[i] = rotations.get(i).height;
			result[i] = i;
		}
		
		
		for(int i=1;i<rotations.size();i++) {
			
			int temp=0;
			for(int j=0; j<i; j++) {
				
				if(rotations.get(i).length<rotations.get(j).length && 
						rotations.get(i).width<rotations.get(j).width) {
					
					result[i]= (temp<max_height[j]) ? j:i ;
					temp = Math.max(temp, max_height[j]);		
					
				}				
			}
			max_height[i] += temp;
		}
		
	
		int maxAt = 0;
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+ " ");
		    maxAt = result[i] > result[maxAt] ? i : maxAt;
		}
		System.out.println();
		System.out.println("Boxes Stacking : Top To Bottom");
		
		int counter = maxAt;
		while(counter!=0) {
			
			System.out.println(rotations.get(counter).length+"*"+rotations.get(counter).width+"*"+
					rotations.get(counter).height);
			counter = result[counter];
			//System.out.println("counter :"+counter);
			
		}
		System.out.println(rotations.get(0).length+"*"+rotations.get(0).width+"*"+
				rotations.get(0).height);
			
	}

	private static List<Box> createAllRotations(List<Box> boxes) {
		
		List<Box> rotations = new ArrayList<>();
		
		for(Box box : boxes) {
			
			rotations.add(box);
			
			// push the first rotation: {max(L, H) x Math.min(L, H) x W}
			rotations.add(new Box(Math.max(box.length, box.height),
					Math.min(box.length, box.height),box.width));
			
			// push the second rotation: {max(W, H) x Math.min(W, H) x L}
			rotations.add(new Box(Math.max(box.width, box.height),
					Math.min(box.width, box.height),box.length));
		}
		
		return rotations;
	}

}
