package CollectionsStudy.QueueExamples;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++)
            stack.push(i*i);

        while(!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
