import java.util.*;

class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        scan.close();
        System.out.println(mergeString(s1, s2));
    }

    public static String mergeString(String s1, String s2) {
        int l1 = 0, l2 = 0;
        String result = "";
        while (l1 < s1.length() && l2 < s2.length()) {
            result += s1.charAt(l1);
            result += s2.charAt(l2);
            l1++;
            l2++;
        }
        if (l1 < s1.length()) {
            result += s1.substring(l1, s1.length());
        }
        if (l2 < s2.length()) {
            result += s2.substring(l2, s2.length());
        }
        return result;
    }
}