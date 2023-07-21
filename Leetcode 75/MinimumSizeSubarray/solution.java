import java.util.*;

import javax.naming.InterruptedNamingException;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scan.nextInt();
        }
        int target = scan.nextInt();
        scan.close();
    }

    public static int bruteForce(int[] nums, int target) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    System.out.println(j - i + 1);
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        return minLen;
    }

    public static int optimat(int[] nums, int target) {
        int minLen = Integer.MAX_VALUE, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                int len = i - map.get(sum - target);

                minLen = Math.min(minLen, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        if (minLen == Integer.MAX_VALUE) {
            minLen = 0;
        }
        return minLen;
    }

    public static int mostOptimat(int[] nums, int target) {
        int minLen = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
