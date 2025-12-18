import java.util.*;
import javax.crypto.*;
import java.security.*;
import java.security.interfaces.*;
public class _1j_RSA {
    public static String encrypt(PublicKey pk, String str) throws Exception{
        Cipher c = Cipher.getInstance("RSA");
        c.init(1, pk);
        return new String(Base64.getEncoder().encode(c.doFinal(str.getBytes())));
    }
    public static String decrypt(PrivateKey pk, String str) throws Exception{
        Cipher c = Cipher.getInstance("RSA");
        c.init(2, pk);
        return new String(c.doFinal(Base64.getDecoder().decode(str.getBytes())));
    }
    public static void main(String[] args) throws Exception{
        KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
        kg.initialize(2048);
        KeyPair kp = kg.generateKeyPair();
        PublicKey pubK = kp.getPublic();
        PrivateKey privK = kp.getPrivate();
        printKeyDetails(pubK, privK);
        String s = "hellp";
        String enc = encrypt(pubK, s);
        System.out.println(enc);
        System.out.println(decrypt(privK, enc));
    }
    public static void printKeyDetails(PublicKey pubK, PrivateKey privK){
        RSAPublicKey rPub = (RSAPublicKey) pubK;
        RSAPrivateKey rPriv = (RSAPrivateKey) privK;
        System.out.println("public modulus : " + rPub.getModulus() + "public exponent : " + rPub.getPublicExponent());
        System.out.println("private modulus : " + rPriv.getModulus() + "private exponent : " + rPriv.getPrivateExponent());
    }
}
