
class TrieNode {

  private Map<Character, TrieNode> childNode = new HashMap<Character, TrieNode>();
  private boolean isLastChar;

  Map<Character, TrieNode> getChildNode() {
    return this.childNode;
  }

  // 마지막 글자인지 여부 Getter
  boolean isLastChar() {
    return this.isLastChar;
  }

  // 마지막 글자인지 여부 Setter
  void setIsLastChar(boolean isLastChar) {
    this.isLastChar = isLastChar;
  }

}

class Trie {

  private TrieNode rootNode;


  public Trie() {
    this.rootNode = new TrieNode();

  }

  public void insert(String word) {
    TrieNode node = this.rootNode;
    for (int i = 0; i < word.length(); i++) {
      node =  node.getChildNode().computeIfAbsent(word.charAt(i), value -> new TrieNode());
    }
    node.setIsLastChar(true);
  }

  public boolean search(String word) {
    TrieNode node = this.rootNode;
    for (int i = 0; i < word.length(); i++) {
      TrieNode childNode = node.getChildNode().get(word.charAt(i));
      if (childNode == null) {
        return false;
      }
      node = childNode;
    }

    return node.isLastChar();

  }

  public boolean startsWith(String prefix) {
    TrieNode node = this.rootNode;
    for (int i = 0; i < prefix.length(); i++) {
      TrieNode childNode = node.getChildNode().get(prefix.charAt(i));
      if (childNode == null) {
        return false;
      }
      node = childNode;
    }

    return true; 
  }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */