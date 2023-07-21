import java.util.*;

// In this question we have to find the area of the container which can hold the most water
// We are given an array of heights where we have to find two such heights such that the 
// the container formed by them contains the maximum water i.e. it has the max area.
public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scan.nextInt();
        }

    }

    public static int bruteForce(int[] height) {
        int maxWater = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                maxWater = (j - i) * Math.min(height[i], height[j]);
            }
        }
        return maxWater;
    }

    public static int betterSol(int[] height) {
        int maxWater = 0;
        int left = 0, right = height.length - 1;
        while(left < right) {
            maxWater = Math.max(maxWater, (right - left)*(Math.min(height[left], height[right])));
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxWater;
    }
}
