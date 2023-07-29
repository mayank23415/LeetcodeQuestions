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
        System.out.println(betterSolution(nums));
    }

    public static int bruteForce(int[] nums) {
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int count = 1;
            while (linearSearch(nums, target + 1)) {
                target++;
                count++;
            }
            res = Math.max(count, res);
        }
        return res;
    }

    public static boolean linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static int betterSolution(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int res = 1, count = 1;
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                list.add(nums[i]);
            }
        }
        System.out.println(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 != list.get(i + 1)) {
                res = Math.max(res, count);
                count = 1;
            } else if (list.get(i) + 1 == list.get(i + 1)) {
                count++;
            }
        }
        return res;
    }

    public static int hashingApproach(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int res = 1, count = 0;
        for (int i : nums) {
            set.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            } else {
                int rep = nums[i];
                while (set.contains(rep + 1)) {
                    rep++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static int priorityQueueSolution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 1, prev = 1, count = 1;
        for (int i : nums) {
            pq.add(i);
        }

        prev = pq.peek();
        pq.poll();
        while (!pq.isEmpty()) {
            if (prev - pq.peek() > 1) {
                count = 1;
                prev = pq.poll();
            } else if (prev - pq.peek() == 0) {
                prev = pq.poll();
            } else {
                count++;
                prev = pq.poll();
            }

            res = Math.max(count, res);
        }
        return res;
    }
}
