import java.util.*;


public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        boolean check = false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            }else {
                map.put(i, 1);
            }
        }
        for(int i: map.keySet()) {
            if(map.get(i)>1) {
                check = true;
            }
        }
        return check;
    }
}
