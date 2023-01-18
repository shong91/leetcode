class Solution {
    public boolean isValid(String s) {
     Map<Character, Character> parentheses = new HashMap<>();
    parentheses.put(')', '(');
    parentheses.put('}', '{');
    parentheses.put(']', '[');

    Stack<Character> stack = new Stack<>();

    for (Character ch : s.toCharArray()) {
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else if (stack.isEmpty() || stack.pop() != parentheses.get(ch)) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}