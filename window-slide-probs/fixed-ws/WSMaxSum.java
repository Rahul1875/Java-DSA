package src.com.pack.fixedws;

public class WSMaxSum {

    public static void main(String[] args){

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        System.out.println(printKMax(arr, arr.length, k));


    }

    private static int printKMax(int[] arr, int length, int k) {

        int i=0;
        int j=0;
        int sum=0;
        int max= Integer.MIN_VALUE;

        while(j<length){
            sum = sum+arr[j];
            if((j-i+1)<k){
                j++;
            } else{
                max=Math.max(max,sum);
                sum = sum-arr[i];
                j++;
                i++;
            }

        }
    return max;
    }

}
