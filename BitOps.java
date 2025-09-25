public class BitOps {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println("Original String: " + s);

        System.out.print("AND with 127: ");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char a = (char) (ch & 127);
            System.out.print(a);
        }
        System.out.println();

        System.out.print("XOR with 127: ");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char x = (char) (ch ^ 127);
            System.out.print(x);
        }
        System.out.println();
    }
}
