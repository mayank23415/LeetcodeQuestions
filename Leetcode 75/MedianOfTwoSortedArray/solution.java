import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] nums1 = new int[n];
        int[] nums2 = new int[m];
        for (int i = 0; i < n; i++) {
            nums1[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums2[i] = scan.nextInt();
        }
        scan.close();
    }

    public static float bruteForce(int[] nums1, int[] nums2) {
        float res = 0;
        int i = 0, j = 0, n = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergedArray[n] = nums1[i];
                i++;
                n++;
            } else {
                mergedArray[n] = nums2[j];
                j++;
                n++;
            }
        }
        while (i < nums1.length) {
            mergedArray[n] = nums1[i];
            i++;
            n++;
        }
        while (j < nums2.length) {
            mergedArray[n] = nums2[j];
            j++;
            n++;
        }

        if (mergedArray.length % 2 == 0) {
            res = (mergedArray[mergedArray.length / 2 - 1] + mergedArray[mergedArray.length / 2]) / 2;
        } else {
            res = mergedArray[mergedArray.length / 2];
        }
        return res;
    }

    
}
