import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    // We only need ONE queue to do this optimally
    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        // 1. Add the new element to the back of the queue
        q.offer(x);
        
        // 2. Count how many elements were ALREADY in the queue
        int size = q.size();
        
        // 3. Rotate the older elements to the back
        for (int i = 0; i < size - 1; i++) {
            // Remove from front, add to back
            q.offer(q.poll()); 
        }
    }
    
    public int pop() {
        // The newest element is safely at the front
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */