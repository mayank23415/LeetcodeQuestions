package Recursion;

import java.util.*;

public class oneToN{
    //Printing numbers from 1 to N and N to 1

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        printNtoOne(n);
        printOnetoN(n);
    }

    public static void printOnetoN(int n) {
        if(n==0)
            return;
        printOnetoN(n-1);
        System.out.println(n);
    }

    public static void printNtoOne(int n) {
        if(n==0)
            return ;
        System.out.println(n);
        printNtoOne(--n);
    }
}