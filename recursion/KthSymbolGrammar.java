package src.main.java.org.example;

public class KthSymbolGrammar {

    public static void main(String[] args) {
        System.out.println("Kth Symbol "+kthGrammar(2, 2));
    }

    public static int kthGrammar(int n, int k) {
        if (n==1 && k==1) {
            return 0;
        }
        int mid = (int)Math.pow(2, n-1)/2;
        if (k<=mid) {
            return kthGrammar(n-1, k);
        }
        return kthGrammar(n-1, k-mid)==0  ? 1 : 0;
    }
}
