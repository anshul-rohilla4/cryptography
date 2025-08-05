import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class shuftCipher {
    public static void main(String[] args) {

        //C = E(Pi) = (Pi+key)mod26  ( P(i) indicates the character of plain text at an index i)
        //Pi = D(Ci) = (Ci-key)mod26;

        String string = "abcdefghijklmnopqrstuvwxyz";

        Map<Character, Integer> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, c - 'a');//A=0 ,...Z=25
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the integer for your KEY");
        int key = sc.nextInt();

        String result = "";

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

    }
}
