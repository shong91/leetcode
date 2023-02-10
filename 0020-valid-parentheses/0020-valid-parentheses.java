class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
  
          for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);
          if (map.containsKey(ch)) {
            stack.push(ch);
          } else {
            if (!stack.isEmpty()) {
              char key = stack.pop();
              if (ch != map.get(key)) {
                return false;
              }
            } else {
              return false;
            }
          }
        }

        return stack.isEmpty();
    }
}