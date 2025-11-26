package lab2;

import java.security.*;
import javax.crypto.Cipher;
import java.security.spec.*;

public class RSAExample {

    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            printKeyDetails(publicKey, privateKey);

            String plaintext = "Hello, RSA!";
            System.out.println("Original Text: " + plaintext);

            byte[] encryptedText = encrypt(plaintext, publicKey);
            System.out.println("Encrypted Text: " + new String(encryptedText));

            String decryptedText = decrypt(encryptedText, privateKey);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] encrypt(String plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plaintext.getBytes());
    }

    public static String decrypt(byte[] ciphertext, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(ciphertext);
        return new String(decryptedBytes);
    }

    public static void printKeyDetails(PublicKey publicKey, PrivateKey privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec publicKeySpec = keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
        RSAPrivateKeySpec privateKeySpec = keyFactory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

        System.out.println("Public Key Modulus: " + publicKeySpec.getModulus());
        System.out.println("Public Key Exponent: " + publicKeySpec.getPublicExponent());
        System.out.println("Private Key Modulus: " + privateKeySpec.getModulus());
        System.out.println("Private Key Exponent: " + privateKeySpec.getPrivateExponent());
    }
}
