package edward.duong.LabW1D1;

import java.util.LinkedList;
import java.util.Queue;

public class LC225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // return 2
        System.out.println(myStack.pop()); // return 2
        System.out.println(myStack.top()); // return 1
        System.out.println(myStack.empty()); // return False
    }
}

class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        if (queue.isEmpty())
            return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}