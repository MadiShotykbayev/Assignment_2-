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
    @Override
    public void add(T element, int index) {
        if(index < 0  index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = new Node(element);
        if(index == 0){
            node.nxt = head;
            head.pre = node;
            head = node;
        }
        else if(index == size){
            tail.nxt = node;
            node.pre = tail;
            tail = node;
        }
        else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.nxt;
            }
            node.nxt = current;
            node.pre = current.pre;
            current.pre.nxt = node;
            current.pre = node;
        }
        size++;
    }
    @Override
    public boolean remove(T item) {
        Node current = head;

        while (current != null) {
            if (current.elem.equals(item)) {
                if (current.pre == null) {
                    head = current.nxt;
                    if (head != null) {
                        head.pre = null;
                    } else {
                        tail = null;
                    }
                } else if (current.nxt == null) {
                    tail = current.pre;
                    tail.nxt = null;
                } else {
                    current.pre.nxt = current.nxt;
                    current.nxt.pre = current.pre;
                }
                size--;
                return true;
            }
            current = current.nxt;
        }
        return false;
    }
    @Override
    public T remove(int index) {
        if (index < 0  index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current;

        if (index == 0) {
            current = head;
            head = current.nxt;
            if (head != null) {
                head.pre = null;
            } else {
                tail = null;
            }
        } else if (index == size - 1) {
            current = tail;
            tail = current.pre;
            if (tail != null) {
                tail.nxt = null;
            } else {
                head = null;
            }
        } else {
            if (index < size / 2) {
                current = head;
                int count = 0;
                while (count < index) {
                    current = current.nxt;
                    count++;
                }
            } else {
                current = tail;
                int count = size - 1;
                while (count > index) {
                    current = current.pre;
                    count--;
                }
            }
            current.pre.nxt = current.nxt;
            current.nxt.prev = current.pre;
        }

        size--;
        return (T) current.elem;
    }
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }




