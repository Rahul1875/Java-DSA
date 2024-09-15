package src.main.java.org.example;

public class PermutationWithSpaces {
    public static void main(String[] args) {
        String ip = "ABC";
        String op = "";

        op += ip.charAt(0);
        ip = ip.substring(1);

        permutationWithSpaces(ip, op);
    }

    public static void permutationWithSpaces(String ip,String output){
        if(ip.length() == 0){
            System.out.println(output);
            return;
        }
        String out1 = output;
        String out2 = output;
        out1 = output+" "+ip.charAt(0);

        out2 = output+ip.charAt(0);

        ip = ip.substring(1);

        permutationWithSpaces(ip,out1);
        permutationWithSpaces(ip,out2);
    }

}
