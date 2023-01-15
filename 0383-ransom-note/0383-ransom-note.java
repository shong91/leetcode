class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
     Map<Character, Integer> map = new HashMap<Character, Integer>();

    for (int i = 0; i < magazine.length(); i++) {
      char currentChar = magazine.charAt(i);
      map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

    }

    for (int i = 0; i < ransomNote.length(); i++) {
      char key = ransomNote.charAt(i);
      if (map.get(key) != null && map.get(key) > 0) {
        // magazine 에서 key-value 로 등록한 값이 ransomeNote 에 있으며, 갯수가 충분하면
        // 사용 갯수 차감
        map.put(key, map.get(key) - 1);
      } else {
        // 그렇지 않으면 -> magazine으로 ransomeNote 를 만들 수 없음
        return false;
      }
    }

    return true;
  }
}