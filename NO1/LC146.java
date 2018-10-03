class LRUCache {
    class ListNode {
        public int key, val;
        public ListNode prev, next;
        
        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    private int size, capacity;
    private ListNode dummy, tail;
    private Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.dummy = new ListNode(0, 0);
        this.tail = this.dummy;
        this.map = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        
        moveToTail(key);
        return tail.val;
    }
    
    public void put(int key, int value) {
        if (this.get(key) != -1) {
            ListNode node = map.get(key);
            node.val = value;
            return;
        }
        
        if (size < capacity) {
            size++;
            ListNode node = new ListNode(key, value);
            tail.next = node;
            node.prev = tail;
            tail = node;
            map.put(key, tail);
            return;
        }
        
        // if reach to the max capacity
        ListNode last = dummy.next;
        map.remove(last.key);
        
        last.key = key;
        last.val = value;
        
        map.put(key, last);
        moveToTail(key);
    }
    
    private void moveToTail(int key) {
        ListNode curt = map.get(key);
        ListNode prev = curt.prev;
        ListNode next = curt.next;
        if (next == null)
            return;
        
        prev.next = next;
        next.prev = prev;
        
        tail.next = curt;
        curt.prev = tail;
        curt.next = null;
        tail = curt;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */