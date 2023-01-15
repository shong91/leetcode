class Solution {
   public static List<String> generateParenthesis(int n) {
    Stack<String> stack = new Stack<>();
    List<String> result = new ArrayList<>();
    recursive(n, 0, 0, stack, result);

    return result;
  }

  public static void recursive(int n, int open, int close, Stack<String> stack,
      List<String> result) {
      
      // base condition 
    if (open == close && open == n) {
      System.out.println(String.join("", stack));
      result.add(String.join("", stack));
      return;
    }
      
      // only add open parantesis if open < n
    if (open < n) {
      stack.push("(");
      recursive(n, open + 1, close, stack, result);
      stack.pop();
    }
      
     // only add close parantesis if open > close
    if (open > close) {
      stack.push(")");
      recursive(n, open, close + 1, stack, result);
      stack.pop();
    }
    return;
  }
}