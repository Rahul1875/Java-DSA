package src.main.java.org.example;

public class Subset {
    public  static  void main(String[] ars) {
        String str = "abc";
        solve(str, "");
    }

    public static void solve(String input, String output) {
        if(input.length() ==0) {
            System.out.println(output);
            return;
        }
        String out1 = output;
        String out2 = output;
        out2+=input.charAt(0);

        input = input.substring(1);

        solve(input, out1);
        solve(input, out2);
    }
}
