package src.main.java.org.example;

public class N_bitBinaryHavingMore1s {
    public static void main(String[] args) {
        int n =2;
        int one =n, zero=n;
        solve(one, zero, n, "");
    }

    private static void solve(int one, int zero, int n, String output) {

        if (n==0) {
            System.out.println(output);
            return;
        }

        String op1 = output;
        op1+="1";
        solve(one+1, zero,n-1, op1);

        if (one>zero) {
            String op2 = output;
            op2+="0";
            solve(one, zero+1,n-1, op2);
        }

    }
}
