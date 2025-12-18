import java.util.Scanner;

public class _1d_subcipher {
    public static String Alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String encrypt(String s, String key){
        StringBuilder sb = new StringBuilder();
        s = s.toUpperCase();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                int idx = Alpha.indexOf(ch);
                sb.append(key.charAt(idx));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static String decrypt(String s, String key){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                int idx = key.indexOf(ch);
                sb.append(Alpha.charAt(idx));
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "Hello world!";
        System.out.println("The original : " + s);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter key : ");
        String key = sc.nextLine();
        String enc = encrypt(s, key);
        System.out.println("Encrpted String : " +enc );
        System.out.println("Decrypted String : "+ decrypt(enc, key));
    }
}
