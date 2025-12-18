import java.util.*;
public class _1e_HillCipher {
    public static String encrypt(int[][] keyMat, String str){
        int[] textVector = toVector(str);
        int[] enc = multiply(keyMat, textVector);
        return toStr(enc);
    }
    public static String decrypt(int[][] keyMat, String str) {
        int[][] iKeyMat = invKey(keyMat);
        int[] textVector = toVector(str);
        int[] dec = multiply(iKeyMat, textVector);
        return toStr(dec);
    }
    public static int[] toVector(String str){
        int[] v = new int[str.length()];
        for(int i=0;i<str.length();i++){
            v[i] = str.charAt(i) - 'A';
        }
        return v;
    }
    public static int[] multiply(int[][] mat, int[] vec){
        int[] res = new int[vec.length];
        for(int i=0;i<mat.length;i++){
            res[i] = 0;
            for(int j=0;j<mat[0].length;j++){
                res[i] += mat[i][j] * vec[j];
            }
            res[i] = res[i]%26;
        }
        return res;
    }
    public static int[][] invKey(int[][] mat){
        int[][] res = new int[mat.length][mat[0].length];

        int det = (mat[0][0]*mat[1][1] - mat[0][1]*mat[1][0])%26;
        det = (det + 26)%26;
        int invDet = getInvDet(det, 26);

        res[0][0] = (mat[0][0] * invDet)%26;
        res[1][1] = (mat[1][1] * invDet)%26;
        res[0][1] = (-mat[0][1] * invDet + 26)%26;
        res[1][0] = (-mat[1][0] * invDet + 26)%26;

        return res;
    }
    public static int getInvDet(int a, int m){
        a = a%m;
        for(int x = 1; x <= m; x++){
            if((a*x)%m == 1)return x;
        }
        return 1;

    }
    public static String toStr(int[] vec){
        StringBuilder sb = new StringBuilder();
        for(int v : vec){
            sb.append((char)(v+'A'));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] keyMat = new int[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                keyMat[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the plainText : {len should be 2} ");
        String str = sc.next().toUpperCase();

        String encText = encrypt(keyMat, str);
        System.out.println(encText);

        String decText = decrypt(keyMat, str);
        System.out.println(decText);


    }
}
