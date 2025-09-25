import java.util.Scanner;

public class Hill {
    public static int[] mul(int[][] k, int[] v) {
        int[] r = new int[v.length];
        for (int i = 0; i < k.length; i++) {
            r[i] = 0;
            for (int j = 0; j < k[i].length; j++) {
                r[i] += k[i][j] * v[j];
            }
            r[i] = r[i] % 26;
        }
        return r;
    }

    public static int inv(int a, int m) {
        a = a % m;
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1)
                return x;
        }
        return 1;
    }

    public static int[][] invKey(int[][] k) {
        int det = (k[0][0] * k[1][1] - k[0][1] * k[1][0]) % 26;
        det = (det + 26) % 26;
        int invDet = inv(det, 26);
        int[][] r = new int[2][2];
        r[0][0] = (k[1][1] * invDet) % 26;
        r[1][1] = (k[0][0] * invDet) % 26;
        r[0][1] = (-k[0][1] * invDet + 26) % 26;
        r[1][0] = (-k[1][0] * invDet + 26) % 26;
        return r;
    }

    public static int[] toVec(String s) {
        int[] v = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            v[i] = s.charAt(i) - 'A';
        return v;
    }

    public static String toStr(int[] v) {
        StringBuilder sb = new StringBuilder();
        for (int x : v)
            sb.append((char) (x + 'A'));
        return sb.toString();
    }

    public static String enc(String pt, int[][] k) {
        int[] m = toVec(pt);
        int[] e = mul(k, m);
        return toStr(e);
    }

    public static String dec(String ct, int[][] k) {
        int[][] ki = invKey(k);
        int[] m = toVec(ct);
        int[] d = mul(ki, m);
        return toStr(d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] k = new int[2][2];
        System.out.println("Enter the 2x2 key matrix (values between 0 and 25):");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                k[i][j] = sc.nextInt();

        System.out.println("Enter the plaintext (length 2, uppercase letters only):");
        String pt = sc.next().toUpperCase();

        String ct = enc(pt, k);
        System.out.println("Encrypted Text: " + ct);

        String dt = dec(ct, k);
        System.out.println("Decrypted Text: " + dt);

        sc.close();
    }
}
