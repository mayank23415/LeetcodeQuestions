import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        int k = scan.nextInt();
        scan.close();
        System.out.println(kthElement(nums, k));
    }

    public static int kthElement(int[] nums, int k) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<Integer>(Collections.reverseOrder());     
        for(int i: nums) {
            pqueue.add(i);
        }

        int res = 0;
        while(k>0) {
            res = pqueue.peek();
            pqueue.poll();
            k--;
        }
        return res;
    }
}
