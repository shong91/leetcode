class Solution {
    public boolean isPalindrome(String s) {
        String regExp = "[^a-zA-Z0-9]";
        s = s.replaceAll(regExp, "").toLowerCase();
        for (int i = 0; i < s.length() / 2; i++) {
          if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
            return false;
          }
        }
        return true;
    }
}