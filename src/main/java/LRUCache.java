public class LRUCache {


    Node[] num;

    public LRUCache(int capacity) {
        num = new Node[capacity];
    }

    public int get(int key) {
        for (Node node : num) {
            if (key == node.key) {
                return node.val;
            }
        }
        return -1;
    }

    public void put(int key, int value) {

    }

    static class Node {
        int val;
        int key;

        Node() {
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }
}


