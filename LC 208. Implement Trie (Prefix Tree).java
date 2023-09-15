class Node {
    private Node[] links = new Node[26];
    private boolean end = false;
    Node() {

    }
    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }
    void put(char ch, Node next) {
        links[ch - 'a'] = next;
    }
    Node get(char ch) {
        return links[ch - 'a'];
    }
    void setEnd() {
        end = true;
    }
    boolean isEnd() {
        return end;
    }
}
class Trie {
    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.containsKey(word.charAt(i)))
                cur.put(word.charAt(i), new Node());
            cur = cur.get(word.charAt(i));
        }
        cur.setEnd();
    }
    
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.containsKey(word.charAt(i)))
                return false;
            cur = cur.get(word.charAt(i));
        }
        return cur.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!cur.containsKey(prefix.charAt(i)))
                return false;
            cur = cur.get(prefix.charAt(i));
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