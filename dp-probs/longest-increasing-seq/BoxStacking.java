package src.com.pack.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Box{
	// constraint: width is never more than length
	int length, width, height;

	Box(int length, int width, int height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
}

public class BoxStacking {

	public static void main(String[] args) {
		
		List<Box> boxes = Arrays.asList(new Box(4, 2, 5),
				new Box(3, 1, 6), new Box(3, 2, 1), new Box(6, 3, 8));
		
		
		System.out.println("The maximum height is :" + maxHeight(boxes));
			

	}

	private static int maxHeight(List<Box> boxes) {
		
		
		// generate rotations of each box
		List<Box> rotations = createAllRotations(boxes);
		
		Collections.sort(rotations,(x,y)->(y.length * y.width - x.length * x.width));
		
		// max_height[i] stores the maximum possible height when i'th box is on the top
		int[] max_height = new int[rotations.size()];
		for(int i=0;i<rotations.size();i++) {
			max_height[i] = rotations.get(i).height;
		}
		
		
		for(int i=1;i<rotations.size();i++) {
			
			int temp=0;
			for(int j=0; j<i; j++) {
				
				if(rotations.get(i).length<rotations.get(j).length && 
						rotations.get(i).width<rotations.get(j).width) {
					
					temp = Math.max(temp, max_height[j]);			
				}				
			}
			max_height[i] += temp;
		}
		
		return Arrays.stream(max_height).max().getAsInt();
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
