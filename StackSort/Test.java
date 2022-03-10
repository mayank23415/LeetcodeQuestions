import java.util.*;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(12);
        stack.push(3);

        System.out.println(stack);
        sortStack(stack);
        System.out.println(stack);
    }

    public static void sortStack(Stack<Integer> s) {
        if(!s.isEmpty()) {
            int x = s.pop();

            sortStack(s);

            sortInsert(s, x);
        }
    }

    public static void sortInsert(Stack<Integer> s, int x) {
        if(s.isEmpty() || x > s.peek()){
            s.push(x);
            return;
        }
        int a = s.pop();
        sortInsert(s,x);
        s.push(a);
    }
}