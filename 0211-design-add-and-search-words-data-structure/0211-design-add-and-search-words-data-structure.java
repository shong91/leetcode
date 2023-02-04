class WordDictionary {

  private WordDictionary[] children;
  private boolean isEnd;

  public WordDictionary() {
    children = new WordDictionary[26];
    isEnd = false;
  }

  public boolean containsKey(char ch) {
    return children[ch - 'a'] != null;
  }

  public WordDictionary get(char ch) {
    return children[ch - 'a'];
  }

  public void put(WordDictionary word, char ch) {
    children[ch - 'a'] = word;
  }

  public void addWord(String word) {
    WordDictionary curr = this;
    for (char c : word.toCharArray()) {
      if (!curr.containsKey(c)) {
        curr.put(new WordDictionary(), c);
      }
      curr = curr.get(c);
    }
    curr.isEnd = true;
  }

  public boolean search(String word) {
    WordDictionary curr = this;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (c == '.') {
        for (WordDictionary ch : curr.children) {
            // not ++i but i+i: NOT to affect for loop 
          if (ch != null && ch.search(word.substring(i+1))) {
            return true;
          }
        }
        return false;
      }

      if (!curr.containsKey(c)) {
        return false;
      }
      curr = curr.get(c);
    }

    return curr != null && curr.isEnd;
  }
}