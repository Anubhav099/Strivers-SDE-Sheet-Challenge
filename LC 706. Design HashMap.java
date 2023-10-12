// key, value -> (0 -> 1e6)

class MyHashMap {
    private class Node {
        int key, val;
        Node next;
        Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    private int SIZE = 13879;
    private int MUL = 1379;
    private Node[] bucket;
    
    public MyHashMap() {
        this.bucket = new Node[SIZE];
    }
    private int hash(int key) {
        return (key * MUL) % SIZE;
    }
    public void put(int key, int value) {
        remove(key);
        int ind = hash(key);
        Node curHeadNode = bucket[ind];
        bucket[ind] = new Node(key, value, curHeadNode);
    }
    
    public int get(int key) {
        int ind = hash(key);
        Node curNode = bucket[ind];
        for (; curNode != null; curNode = curNode.next)
            if (curNode.key == key) return curNode.val;
        return -1;
    }
    
    public void remove(int key) {
        int ind = hash(key);
        Node curNode = bucket[ind];
        if (curNode == null)
            return;
        else if (curNode.key == key)
            bucket[ind] = curNode.next;
        else for (; curNode.next != null; curNode = curNode.next)
            if (curNode.next.key == key) {
                curNode.next = curNode.next.next;
                return;
            }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */