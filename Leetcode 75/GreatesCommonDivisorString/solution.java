import java.util.*;

// End case 1- The length of the
class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next(), str2 = scan.next();
        scan.close();
        System.out.println(str1.substring(GCD(str1.length(), str2.length())));
    }

    public static int GCD(int a, int b) {
        return b==0? a: GCD(b , a%b);
    }
}