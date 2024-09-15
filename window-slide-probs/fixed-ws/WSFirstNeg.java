package src.com.pack.fixedws;

import java.util.*;
public class WSFirstNeg {

    public static void main(String[] args){
        int arr[] = { -8,2,3,-4,-5,-1,8,2 };
        int k = 3;
        printFirstNeg(arr, arr.length, k);
    }

    private static void printFirstNeg(int[] arr, int length, int k) {

        int i=0;
        int j=0;
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<>();
        while(j<length){
            if(arr[j]<0){
                queue.add(arr[j]);
            }
            if((j-i+1)<k){
                j++;
            }else{
                if(queue.size()==0){
                    list.add(0);
                }else{
                    list.add(queue.peek());
                    if(queue.peek()==arr[i]){
                        queue.poll();
                    }

                }
                i++;
                j++;
            }
        }

        for (int m:list) {
            System.out.println(m+"->");
        }
    }

}
