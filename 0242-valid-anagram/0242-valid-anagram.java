class Solution {
    public boolean isAnagram(String s, String t) {
    
    // check if both strings length are same
    if (s.length() != s.length()) {
      return false;
    }

    // 문제의 키 포인트! 제약 조건(문자열은 알파벳 소문자로 이루어짐) 을 이용하여 배열의 길이를 제한하고, 비트마스크 연산
    // constraints: s and t consist of lowercase English letters.
    int[] arr = new int[26];
    for (int i = 0; i < s.length() ; i++) {
      // 비트마스크를 이용
      arr[s.charAt(i) - 'a']++;
    }

    for (int i = 0; i < t.length() ; i++) {
      // 비트마스크를 이용
      arr[t.charAt(i) - 'a']--;
    }

    for (int count : arr) {
      if (count != 0 ) {
        return false;
      }
    }

    return true;
    }
}