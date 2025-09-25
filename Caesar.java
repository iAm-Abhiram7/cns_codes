import java.util.Scanner;

public class Caesar {
    public static String enc(String msg, int k) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            if (Character.isUpperCase(ch)) {
                char c = (char) (((int) ch + k - 65) % 26 + 65);
                out.append(c);
            } else if (Character.isLowerCase(ch)) {
                char c = (char) (((int) ch + k - 97) % 26 + 97);
                out.append(c);
            } else {
                out.append(ch);
            }
        }
        return out.toString();
    }

    public static String dec(String msg, int k) {
        return enc(msg, 26 - k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message: ");
        String msg = sc.nextLine();

        System.out.print("Enter the shift value (1-25): ");
        int k = sc.nextInt();

        if (k < 1 || k > 25) {
            System.out.println("Invalid shift value. Please enter a number between 1 and 25.");
            return;
        }

        String encMsg = enc(msg, k);
        System.out.println("Encrypted Message: " + encMsg);

        String decMsg = dec(encMsg, k);
        System.out.println("Decrypted Message: " + decMsg);

        sc.close();
    }
}
