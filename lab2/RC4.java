import java.util.*;
public class _1i_rc4 {
    static int x = 0;
    static int y = 0;
    static byte[] arr = new byte[256];
    public _1i_rc4(byte[] key){
        init(key);
    }
    public static void init(byte[] key){
        int kl = key.length;
        for(int i=0;i<256;i++){
            arr[i] = (byte)i;
        }
        int j = 0;
        for(int i=0;i<256;i++){
            j = (j + arr[i] + key[i%kl]) & 0xFF;
            swap(i,j);
        }
    }
    public static byte keyItem(){
        x = (x+1)&0xFF;
        y = (y+arr[x])&0xFF;
        swap(x,y);
        return arr[(arr[x] + arr[y]) & 0xFF];
    }
    public static byte[] encrypt(byte[] plainText){
        byte[] cipherText = new byte[plainText.length];
        for(int i=0;i< plainText.length;i++){
            cipherText[i] = (byte)(plainText[i] ^ keyItem());
        }
        return cipherText;
    }
    public static void swap(int i, int j){
        byte temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your RC4 encryption key : ");
        String key  = sc.nextLine();
        byte[] kb = key.getBytes();
        _1i_rc4 rc4 = new _1i_rc4(kb);
        String str = "hello world";
        System.out.println("Encrypted text : ");
        byte[] enc = rc4.encrypt(str.getBytes());
        System.out.println(new String(enc));
        System.out.println("Decrpted text : ");
        System.out.println(new String(rc4.encrypt(enc)));

    }
}
