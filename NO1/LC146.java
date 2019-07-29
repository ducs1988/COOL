class LRUCache {
    
    class Node {
        int key, val;
        Node prev, next;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
            prev = null;
            next = null;
        }
    }

    int capacity;
    Map<Integer, Node> map; // key, node
    Node dummy, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dummy = new Node(0,0);
        tail = dummy;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            moveToTail(map.get(key));
            return;
        }
        
        Node node = new Node(key, value);
        tail.next = node;
        node.prev = tail;
        tail = node;
        map.put(key, node);
        
        if (map.size() > capacity) {
            Node remove = dummy.next;
            map.remove(remove.key);
            Node next = remove.next;
            dummy.next = next;
            next.prev = dummy;
        }
    }
    
    private void moveToTail(Node node) {
        if (node.next != null) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */