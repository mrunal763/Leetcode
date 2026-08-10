class Node {
    int key, value, cnt;
    Node prev, next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.cnt = 1;
    }
}

class DLL {
    int size;
    Node head, tail;

    DLL() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;

        size = 0;
    }

    void addFront(Node node) {
        Node temp = head.next;

        node.next = temp;
        node.prev = head;

        head.next = node;
        temp.prev = node;

        size++;
    }

    void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;
    }
}

class LFUCache {

    private Map<Integer, Node> keyNode;
    private Map<Integer, DLL> freqListMap;

    private int capacity;
    private int minFreq;
    private int curSize;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.curSize = 0;

        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    private void updateFreq(Node node) {
        keyNode.remove(node.key);

        DLL currList = freqListMap.get(node.cnt);
        currList.removeNode(node);

        if (node.cnt == minFreq && currList.size == 0) {
            minFreq++;
        }

        node.cnt++;

        DLL nextList = freqListMap.getOrDefault(node.cnt, new DLL());
        nextList.addFront(node);

        freqListMap.put(node.cnt, nextList);
        keyNode.put(node.key, node);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key)) {
            return -1;
        }

        Node node = keyNode.get(key);
        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        if (curSize == capacity) {
            DLL list = freqListMap.get(minFreq);

            Node nodeToDelete = list.tail.prev;

            keyNode.remove(nodeToDelete.key);
            list.removeNode(nodeToDelete);

            curSize--;
        }

        curSize++;
        minFreq = 1;

        DLL list = freqListMap.getOrDefault(1, new DLL());

        Node node = new Node(key, value);

        list.addFront(node);

        freqListMap.put(1, list);
        keyNode.put(key, node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */