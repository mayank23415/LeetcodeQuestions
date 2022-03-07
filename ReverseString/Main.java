package ReverseString;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        char[] arr = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        System.out.println(arr);
        reverse(arr, 0, arr.length-1);
        System.out.println(arr);
    }

    public static void reverse(char[] arr, int i, int j) {
        if(i >= j) {
            return;
        }
        
        swap(arr, i, j);
        reverse(arr, ++i, --j);
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

