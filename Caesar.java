import java.util.*;

public class _1c_ceaser {
    public static String encrypt(String s, int key){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                sb.append((char)((ch-'A'+key)%26 + 'A'));
            } else if (Character.isLowerCase(ch)) {
                sb.append((char)((ch-'a'+key)%26 + 'a'));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static String decrypt(String s, int key){
        return encrypt(s,26-key);
    }
    public static void main(String[] args) {
        String s = "Hello world!";
        System.out.println("The original : " + s);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key size : ");
        int key = sc.nextInt();
        String enc = encrypt(s, key);
        System.out.println("Encrpted String : " +enc );
        System.out.println("Decrypted String : "+ decrypt(enc, key));
    }
}
