import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }

        System.out.println(optimisedBruteForce(nums));
    }

    public static List<List<Integer>> mostOptimised(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    list.add(temp);
                    k--;
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return list;
    }

    // The below code is the brute force O(n3)
    public static List<List<Integer>> bruteForce(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        if (!set.contains(temp)) {
                            set.add(temp);
                        }
                    }
                }
            }
        }

        for (List<Integer> temp : set) {
            list.add(temp);
        }
        return list;
    }

    public static List<List<Integer>> optimisedBruteForce(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> checkSet = new HashSet<>();
        Set<List<Integer>> resSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            checkSet.clear();
            for (int j = i + 1; j < nums.length; j++) {
                if (checkSet.contains(-(nums[i] + nums[j]))) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(-(nums[i] + nums[j]));
                    Collections.sort(temp);
                    if (!resSet.contains(temp)) {
                        resSet.add(temp);
                    }
                }
                checkSet.add(nums[j]);
            }
        }

        res.addAll(resSet);
        return res;
    }
}
