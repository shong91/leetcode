class Solution {
    public boolean isPalindrome(String s) {
          // remove non-printable ASCII characters
    s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
   
    // use two pointers
    int start = 0;
    int end = s.length() - 1;
    while (start < end) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
      // move pointers 
      start++;
      end--;
    }
    return true;
    }
}