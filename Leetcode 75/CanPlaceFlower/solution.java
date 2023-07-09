import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] flowerBed = new int[n];
        for (int i = 0; i < n; i++) {
            flowerBed[i] = scan.nextInt();
        }
        int flowers = scan.nextInt();
        scan.close();

    }

    public static boolean canPlace(int[] flowerbed, int n) {
        boolean result = false;

        int i = 0, bedCount = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 1) {
                i += 2;
            }else {

            }
        }
        return result;
    }
}
