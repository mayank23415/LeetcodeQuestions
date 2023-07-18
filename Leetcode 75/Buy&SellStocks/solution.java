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
    }

    public static int bruteForce(int[] prices) {
        int buyingPrice = 0, sellingPrice = 0, maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            buyingPrice = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                sellingPrice = prices[j];
                maxProfit = Math.max(maxProfit, (sellingPrice - buyingPrice));
            }
        }
        return maxProfit;
    }

    public static int optimal(int[] prices) {
        return 9;
    }

    public static int better(int[] prices) {
        int[] maxPrices = new int[prices.length];
        maxPrices[prices.length - 1] = prices[prices.length - 1];

        return 0;
    }

    public static int optimat(int[] prices) {
        int minSoFar = Integer.MAX_VALUE, maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-minSoFar);
        }
        return maxProfit;
    }
}
