import java.util.Scanner;

public class SubCipher {
    private static final String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String enc(String msg, String key) {
        StringBuilder out = new StringBuilder();
        msg = msg.toUpperCase();
        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            if (Character.isLetter(ch)) {
                int idx = ABC.indexOf(ch);
                char c = key.charAt(idx);
                out.append(c);
            } else {
                out.append(ch);
            }
        }
        return out.toString();
    }

    public static String dec(String encMsg, String key) {
        StringBuilder out = new StringBuilder();
        encMsg = encMsg.toUpperCase();
        for (int i = 0; i < encMsg.length(); i++) {
            char ch = encMsg.charAt(i);
            if (Character.isLetter(ch)) {
                int idx = key.indexOf(ch);
                char c = ABC.charAt(idx);
                out.append(c);
            } else {
                out.append(ch);
            }
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String key = "QWERTYUIOPLKJHGFDSAZXCVBNM";
        System.out.println("Using substitution key: " + key);

        System.out.print("Enter the message to encrypt: ");
        String msg = sc.nextLine();

        String encMsg = enc(msg, key);
        System.out.println("Encrypted Message: " + encMsg);

        String decMsg = dec(encMsg, key);
        System.out.println("Decrypted Message: " + decMsg);

        sc.close();
    }
}
