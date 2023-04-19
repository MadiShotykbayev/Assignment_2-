public class MyLinkedList<T> implements MyList<T> {
    private class Node{
        T elem;
        Node nxt;
        Node pre;
        public Node(T element) {
            this.elem = element;
            this.nxt = null;
            this.pre = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }
