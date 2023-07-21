import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            colors[i] = scan.nextInt();
        }
        scan.close();
    }

    public static void optimal(int[] nums) {
        // This approach uses dutch national flag algorithm
        int low = 0, mid = 0, high = nums.length;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, high, mid);
                high--;
            }
        }
    }

    public static void bruteForce(int[] colors, int low, int high) {
        if (low < high) {
            int p = partition(colors, low, high);
            bruteForce(colors, low, p - 1);
            bruteForce(colors, p + 1, high);
        }
    }

    public static void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }

    public static int partition(int[] colors, int low, int high) {
        int p = colors[high];
        int i = low - 1;
        for (int j = low; j < high - 1; j++) {
            if (colors[j] < p) {
                i++;
                swap(colors, i, j);
            }
        }
        swap(colors, i + 1, high);
        return i + 1;
    }
}
