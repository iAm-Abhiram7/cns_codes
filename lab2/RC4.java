package lab2;

import java.util.Scanner;

public class RC4 {
    private byte[] S = new byte[256];
    private int x = 0;
    private int y = 0;

    public RC4(byte[] key) {
        init(key);
    }

    private void init(byte[] key) {
        int keyLength = key.length;
        for (int i = 0; i < 256; i++) {
            S[i] = (byte) i;
        }
        int j = 0;
        for (int i = 0; i < 256; i++) {
            j = (j + S[i] + key[i % keyLength]) & 0xFF;
            swap(i, j);
        }
    }

    private void swap(int i, int j) {
        byte temp = S[i];
        S[i] = S[j];
        S[j] = temp;
    }

    public byte[] encrypt(byte[] plaintext) {
        byte[] ciphertext = new byte[plaintext.length];
        for (int i = 0; i < plaintext.length; i++) {
            ciphertext[i] = (byte) (plaintext[i] ^ keyItem());
        }
        return ciphertext;
    }

    private byte keyItem() {
        x = (x + 1) & 0xFF;
        y = (y + S[x]) & 0xFF;
        swap(x, y);
        return S[(S[x] + S[y]) & 0xFF];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a key for RC4 encryption:");
        String keyString = scanner.nextLine();
        byte[] key = keyString.getBytes();

        // Encryption
        RC4 rc4Encrypt = new RC4(key);
        String plaintext = "Hello World";
        System.out.println("Original Text: " + plaintext);

        byte[] ciphertext = rc4Encrypt.encrypt(plaintext.getBytes());
        System.out.println("Encrypted Bytes:");
        for (byte b : ciphertext)
            System.out.print(b + " ");
        System.out.println();

        // Decryption (NEW instance)
        RC4 rc4Decrypt = new RC4(key);
        byte[] decryptedBytes = rc4Decrypt.encrypt(ciphertext);
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted Text: " + decryptedText);

        scanner.close();
    }

}
