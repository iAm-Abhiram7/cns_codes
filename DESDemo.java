import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;
public class _1f_DES {
    public static SecretKey generateSecretKey() throws Exception{
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        kg.init(56);
        return kg.generateKey();
    }
    public static String encrypt(SecretKey sk, String str) throws Exception{
        Cipher c = Cipher.getInstance("DES");
        c.init(Cipher.ENCRYPT_MODE, sk);
        return Base64.getEncoder().encodeToString(c.doFinal(str.getBytes()));
    }
    public static String decrypt(SecretKey sk, String encStr) throws Exception{
        Cipher c = Cipher.getInstance("DES");
        c.init(Cipher.DECRYPT_MODE, sk);
        return new String(c.doFinal(Base64.getDecoder().decode(encStr.getBytes())));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        System.out.println("Enter key size : ");
        try{
            SecretKey sk = generateSecretKey();
            String enc = encrypt(sk, st);
            System.out.println("Encrptted : " + enc);
            System.out.println("Decrypted : " + decrypt(sk, enc));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
