package src.com.pack.varws;

public class LargestSubarray {

    public static void main(String[] args){

        int[] arr = {1,2,1,2,1};
        int k =3;

        System.out.println(findLargestSubarray(arr, arr.length, k));

    }

    private static int findLargestSubarray(int[] arr, int n, int k) {
        int max = 0;
        int i=0, j=0;
        int sum=0;

        while(j<n){
            sum+=arr[j];

            if(sum<k){
                j++;
            } else if(sum==k){
                max = Math.max(max,(j-i+1));
                j++;
            } else {
                while(sum>k){
                    sum = sum - arr[i];
                    i++;
                    if(sum==k){
                        max = Math.max(max,(j-i+1));
                    }
                }
                j++;
            }
        }
        return max;
    }
}
