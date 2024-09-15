package src.com.pack.fixedws;

public class MaxNumberFromSubArray {


    public static void main(String[] args){

        int arr[] = {1, 3,-1,-3,5,3,6,7};
        int k = 3;
        getMaxNum(arr, arr.length, k);


    }

    private static void getMaxNum(int[] arr, int length, int k) {


        int i=0;
        int j=0;
        int max= Integer.MIN_VALUE;


        while (j<length) {
            // we can also use list here to store and then get max and remove if max==list.get(i)
            // while sliding window
            max = Math.max(max,arr[j]);

            if(j-i+1<k) {
                j++;
            } else {

                System.out.println(max+"->");
                if (max == arr[i])
                    max =0;
                i++;
                j++;
            }

        }



    }

}
