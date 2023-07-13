import java.util.*;

public class solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scan.nextInt();
            intervals[i][1] = scan.nextInt();
        }
        scan.close();
        int[][] res = mergeIntervals(intervals);
        for (int[] temp : res) {
            System.out.println(temp[0] + " " + temp[1]);
        }
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        LinkedList<int[]> mergedList = new LinkedList<>();
        // Column wise sort
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        for(int i=0; i<intervals.length; i++) {
            if(mergedList.isEmpty() || mergedList.getLast()[1] < intervals[i][0]) {
                mergedList.add(intervals[i]);
            }else {
                mergedList.getLast()[1] = Math.max(mergedList.getLast()[1], intervals[i][1]);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
