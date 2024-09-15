package src.main.java.org.example;

public class permuteCaseChange {
    public static void main(String[] args) {
        String ip = "abc";
        String op = "";
        solve(ip, op);
    }

    public static void solve(String ip,String output){
        if(ip.length() == 0){
            System.out.println(output);
            return;
        }

        String out1 = output;
        String out2 = output;
        out1 = output+ip.charAt(0);
        out2 = output+Character.toUpperCase(ip.charAt(0));

        ip = ip.substring(1);

        solve(ip,out1);
        solve(ip,out2);

    }

}
