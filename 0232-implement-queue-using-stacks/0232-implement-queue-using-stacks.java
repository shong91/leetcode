class MyQueue {
    Stack stack = new Stack();
    public MyQueue() {
        
    }
    
   
  public void push(int x) {
    stack.push(x);

  }

  public int pop() {
    return (int) stack.remove(0);


  }

  public int peek() {
    return (int) stack.firstElement();

  }

  public boolean empty() {
    return stack.empty();

  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */