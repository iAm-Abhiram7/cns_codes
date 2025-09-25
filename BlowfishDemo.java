import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class BlowfishDemo {
    public static SecretKey genKey(int bits) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("Blowfish");
        kg.init(bits);
        return kg.generateKey();
    }

    public static String enc(String pt, SecretKey key) throws Exception {
        Cipher c = Cipher.getInstance("Blowfish");
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] out = c.doFinal(pt.getBytes());
        return Base64.getEncoder().encodeToString(out);
    }

    public static String dec(String ct, SecretKey key) throws Exception {
        Cipher c = Cipher.getInstance("Blowfish");
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] out = c.doFinal(Base64.getDecoder().decode(ct));
        return new String(out);
    }

    public static void main(String[] args) {
        try {
            SecretKey k = genKey(128);
            String pt = "Hello, World!";
            System.out.println("Original Text: " + pt);
            String ct = enc(pt, k);
            System.out.println("Encrypted Text: " + ct);
            String dt = dec(ct, k);
            System.out.println("Decrypted Text: " + dt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
