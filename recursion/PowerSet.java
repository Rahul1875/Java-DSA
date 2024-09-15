package src.main.java.org.example;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    static List<List<Integer>> Ans = new ArrayList<>();
    public  static  void main(String[] ars) {
        int[] nums = new int[] {-1,1,-2};
        List<Integer> list = new ArrayList<>();
        solve(nums, list);
        System.out.println(Ans);
    }

    public static void solve(int[] input, List<Integer> list) {
        if(input.length ==0) {
            Ans.add(list);
            return;
        }
        List<Integer> list1 = new ArrayList<>(list);
        List<Integer> list2 = new ArrayList<>(list);
        list2.add(input[0]);

        int[] updatedInput = new int[input.length-1];
        System.arraycopy(input, 1, updatedInput, 0, input.length-1);

        solve(updatedInput, list1);
        solve(updatedInput, list2);
    }
}
