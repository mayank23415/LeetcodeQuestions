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
        System.out.println(optimal(nums));
    }

    public static int bruteForce(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) >= nums.length / 2) {
                res = i;
            }
        }
        return res;
    }

    public static int optimal(int[] nums) {
        int element = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0) {
                element = nums[i];
                count++;
            }else if(element == nums[i]) {
                count++;
            }else {
                count--;
            }
        }

        return element;
    }
}