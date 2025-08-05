import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class shiftCipher {
    public static void main(String[] args) {

        //C = E(Pi) = (Pi+key)mod26  ( P(i) indicates the character of plain text at an index i)
        //Pi = D(Ci) = (Ci-key)mod26;

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose operation :");
        System.out.println("1. Plain text  -> Cipher text");
        System.out.println("2. Cipher text -> Plain text");
        int choice = sc.nextInt();


        String string = "abcdefghijklmnopqrstuvwxyz";

        Map<Character, Integer> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, c - 'a');//A=0 ,...Z=25
        }
        System.out.println("Enter the integer for your KEY");
        int key = sc.nextInt();

        String result = "";


        if(choice ==1) { //plain text to cipher text
            System.out.println("Enter the plain text.");
            String plainT = sc.next();
            sc.close();

            System.out.println("Plain text: " + plainT);

            for (int i = 0; i < plainT.length(); i++) {
                int Pi = map.get(plainT.charAt(i));
                int num = (Pi + key) % 26;
                result += string.charAt(num);
            }
            System.out.println("Cipher text: " + result);
            result="";
        }
        else { //cipher text to plain text
            System.out.println("Enter the cipher text");
            String CipherT=sc.next();
            sc.close();

            System.out.println("Cipher text: "+CipherT);

            for(int i=0;i<CipherT.length();i++){
                int Ci=map.get(CipherT.charAt(i));
                int num=((Ci-key) % 26 + 26)%26;
                result += string.charAt(num);
            }
            System.out.println(result);
            result="";
        }

    }
}
