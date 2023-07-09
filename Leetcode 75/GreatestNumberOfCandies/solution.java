import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] candies = new int[n];
        for(int i=0; i<candies.length; i++) {
            candies[i] = scan.nextInt();
        }
        int extraCandies = scan.nextInt();
        scan.close();
        boolean[] canHave = greatestNumberOfCandies(candies, extraCandies);
        for (boolean b : canHave) {
            System.out.println(b);
        }
    }

    public static boolean[] greatestNumberOfCandies(int[] candies, int extraCandies) {
        boolean[] result = new boolean[candies.length];
        int max = 0;
        for (int candy : candies) {
            if(candy > max) {
                max = candy;
            }
        }
        for(int i=0; i<candies.length; i++) {
            if((candies[i]+extraCandies)>=max){
                result[i] = true;
            }else {
                result[i] = false;
            }
        }
        return result;
    }
}
