public class XorZero {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println("Original String: " + s);
        System.out.print("XOR with 0: ");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char r = (char) (ch ^ 0);
            System.out.print(r);
        }
        System.out.println();
    }
}
