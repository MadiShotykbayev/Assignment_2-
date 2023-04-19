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
    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    @Override
    public void add(T element) {
        Node node = new Node(element);
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.nxt = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }


