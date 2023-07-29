import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();

        scan.close();
    }

    public static int bruteForce(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 1, count = 1;
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                count++;
            } else {
                count = 1;
                set.clear();
            }
            Math.max(res, count);
        }
        return res;
    }
}
