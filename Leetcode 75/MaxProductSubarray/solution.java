import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        scan.close();
        optimal(nums);
    }

    public static int bruteForce(int[] nums) {
        int maxProd = 0, prod = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = i; k <= j; k++) {
                    prod = prod * nums[k];
                    maxProd = Math.max(maxProd, prod);
                }
            }
        }
        return maxProd;
    }

    public static int optimal(int[] nums) {
        int max = Integer.MIN_VALUE, prefix = 1, suffix = 1;
        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
